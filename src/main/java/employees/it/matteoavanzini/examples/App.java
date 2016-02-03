package employees.it.matteoavanzini.examples;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

import employees.it.matteoavanzini.examples.model.Department;
import employees.it.matteoavanzini.examples.model.Employee;

public class App 
{
	public static final int COLUMN_WIDTH = 25;
	public static final int ROW_LIMIT = 10;
	private int page = 0;
	
	private static void saveEmployeeTest(Session session) {
		
		session.beginTransaction();
        Employee employee = new Employee();
        session.save(employee);
        session.getTransaction().commit();
	}
	
	private List<Employee> getEmployees(int start, int limit) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from Employee");
		query.setMaxResults(limit);
		query.setFirstResult(start);
		List<Employee> employees = query.list();
		return employees;
	}
	
	private Terminal openTerminal() {
		Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
    		terminal.enterPrivateMode();
    		terminal.setCursorVisible(false);
    		return terminal;
	}
	
	private void closeTerminal(Terminal terminal) {
		terminal.exitPrivateMode();
    		terminal.flush();
	}
	
	public App() {
		Terminal terminal = openTerminal();
		printTable(terminal);
	    	handleInput(terminal);
	    	closeTerminal(terminal);
	}
	
	private void handleInput(Terminal t) {
		while (true) {
	    		Key key = t.readInput();
	    		if (key != null) {
	    			switch (key.getCharacter()) {
		    			case 'n':
		    				page++;
			    			printTable(t);
		    				break;
		    			case 'p':
		    				page--;
		    				if (page < 0) page = 0;
		    				printTable(t);
		    				break;
	    			}
	    			
	    			if (key.getKind() == Key.Kind.Escape) {
		    			break;
		    		}
	    		}
	    	}
	}
	
    public static void main(String[] args)
    {
	    	new App();
	    	System.exit(0);
    }
    
    private void printTable(Terminal terminal) {
    		List<Employee> employees = getEmployees(page, ROW_LIMIT);
		terminal.clearScreen();
	    	int row = 0;
	    	printRow(terminal, row, new String[] { 
						    			"Nome", 
						    			"Cognome", 
						    			"Assunto il", 
						    			"Reparto"
					    			});
			terminal.moveCursor(0, 1);
			writeLine(terminal);
	    	row = 2;
	    	for (Employee employee : employees) {
	    		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    		printRow(terminal, row, new String[] { 
	    				employee.getFirstName(), 
	    				employee.getLastName(), 
	    				sdf.format(employee.getHireDate()), 
	    				employee.getDepartments().get(0).getDepartmentEmployeePK().getDepartment().getDeptName()
					});
	    		row++;
	    	}
	    	terminal.moveCursor(0, row);
	    	writeLine(terminal);
	    	
	    	write(terminal, "ESC : chiudi | n : Next Page | p : Previous Page");
    }
    
    private void printRow(Terminal terminal, int row, String[] values) {
    		terminal.moveCursor(1, row);
		write(terminal, values[0]);
		terminal.moveCursor(1*COLUMN_WIDTH, row);
		write(terminal, values[1]);
		terminal.moveCursor(2*COLUMN_WIDTH, row);
		write(terminal, values[2]);
		terminal.moveCursor(3*COLUMN_WIDTH, row);
		write(terminal, values[3]);
    }
    
    private void writeLine(Terminal t) {
    		TerminalSize size = t.getTerminalSize();
    		for (int i=0; i<size.getColumns(); i++) {
    			t.putCharacter('-');
    		}
    }
    
    private void write(Terminal terminal, String str) {
    		char[] charArray = str.toCharArray();
    		for (char c : charArray) {
    			terminal.putCharacter(c);
    		}
    }
    
    // solo per esempio, ma non viene richiamato!
    private void doHibernate() {
    		System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Department dep = (Department) session.get(Department.class, "d005");
        if (dep!=null) {
        		System.out.println(dep.getDeptName());
        } else {
        		System.out.println(" dep = NULL ");
        }
        
        try {
	        Employee georgiFacello = (Employee) session.get(Employee.class, 10001);
	        if (georgiFacello != null) {
	        	System.out.println( "Ciao io sono " + georgiFacello.getFirstName() );
	        	System.out.println( "Il mio reparto è " + georgiFacello.getDepartments().get(0).getDepartmentEmployeePK().getDepartment().getDeptName() );
	        	System.out.println( "Il mio salario è " + georgiFacello.getSalaries().get(0).getSalary() );
	        } else {
	        	System.out.println( "georgiFacello is NULL!!!! " );
	        }
        } catch (Exception err) {
        		System.out.println(err.getMessage());
        }
    }
}
