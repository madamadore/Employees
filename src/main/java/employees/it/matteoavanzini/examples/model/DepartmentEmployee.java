package employees.it.matteoavanzini.examples.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="dept_emp")
public class DepartmentEmployee {
	
	@EmbeddedId
	private DeptEmpPK departmentEmployeePK;
	
	@Column(name="from_date")
	private Date fromDate;
	
	@Column(name="to_date")
	private Date toDate;

	public DeptEmpPK getDepartmentEmployeePK() {
		return departmentEmployeePK;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setDepartmentEmployeePK(DeptEmpPK departmentEmployeePK) {
		this.departmentEmployeePK = departmentEmployeePK;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	
}
