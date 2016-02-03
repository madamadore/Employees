package employees.it.matteoavanzini.examples;

import java.nio.charset.Charset;
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
	private static void saveEmployeeTest(Session session) {
		
		session.beginTransaction();
        Employee employee = new Employee();
        session.save(employee);
        session.getTransaction().commit();
	}
	
	private List<Employee> getEmployees(int start, int limit) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from Employee");
		query.setMaxResults(10);
		List<Employee> employees = query.list();
		return employees;
	}
	
	public App() {
		Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
    	
	    	terminal.enterPrivateMode();
	    	terminal.applyBackgroundColor(Terminal.Color.BLUE);
	    	
	    	TerminalSize terminalSize = terminal.getTerminalSize();
	    	
	    	terminal.moveCursor(10, 5); 
	    	write(terminal, "Hello");
	    	terminal.setCursorVisible(false);
	    	
	    	while (true) {
	    		Key key = terminal.readInput();
	    		
	    		if (key != null  && key.getKind() == Key.Kind.Escape) {
	    			break;
	    		}
	    	}
	    	
	    	
	    	terminal.exitPrivateMode();
	    	terminal.flush();
	}
	
    public static void main(String[] args)
    {
	    	new App();
	    	System.exit(0);
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
