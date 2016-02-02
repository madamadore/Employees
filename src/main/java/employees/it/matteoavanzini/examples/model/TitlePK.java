package employees.it.matteoavanzini.examples.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class TitlePK implements Serializable {
	
	@Column(name="emp_no")
	protected Employee employee;
	
	@Column(name="title")
    protected String title;
	
	@Column(name="from_date")
    protected Date fromDate;

    public TitlePK() {}

    public TitlePK(Employee employee, String title, Date fromDate) {
        this.employee = employee;
        this.title = title;
        this.fromDate = fromDate;
    }

	public Employee getEmployee() {
		return employee;
	}

	public String getTitle() {
		return title;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
    
    
}
