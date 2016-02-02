package employees.it.matteoavanzini.examples.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="salaries")
public class Salary {
	
	@EmbeddedId
	private SalaryPK salaryPK;
	
	@Column(name="salary")
	private int salary;
	
	@Column(name="to_date")
	private Date toDate;

	public SalaryPK getSalaryPK() {
		return salaryPK;
	}

	public int getSalary() {
		return salary;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setSalaryPK(SalaryPK salaryPK) {
		this.salaryPK = salaryPK;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	
}
