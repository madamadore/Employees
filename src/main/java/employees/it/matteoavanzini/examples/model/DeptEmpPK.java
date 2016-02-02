package employees.it.matteoavanzini.examples.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class DeptEmpPK implements Serializable {
	
	@ManyToOne
	@JoinColumn(name="emp_no", nullable = false, updatable = false)
	protected Employee employee;
	
	@ManyToOne
	@JoinColumn(name="dept_no", columnDefinition="char(4)", nullable = false, updatable = false)
	protected Department department;

	public Employee getEmployee() {
		return employee;
	}

	public Department getDepartment() {
		return department;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}