package employees.it.matteoavanzini.examples;

import org.hibernate.Session;

import employees.it.matteoavanzini.examples.model.Department;
import employees.it.matteoavanzini.examples.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
	private static void saveEmployeeTest(Session session) {
		session.beginTransaction();
        Employee employee = new Employee();
        session.save(employee);
        session.getTransaction().commit();
	}
	
    public static void main( String[] args )
    {
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
