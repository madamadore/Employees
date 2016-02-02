package employees.it.matteoavanzini.examples.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class SalaryPK implements Serializable {
	
	@ManyToOne
	@JoinColumn(name="emp_no")
	private Employee employee;
	
	@Column(name="from_date")
	private Date fromDate;

	public Employee getEmployee() {
		return employee;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	
	
}
