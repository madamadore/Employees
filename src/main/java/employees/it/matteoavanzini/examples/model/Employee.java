package employees.it.matteoavanzini.examples.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {
	
	@OneToMany(mappedBy="departmentEmployeePK.employee", fetch=FetchType.LAZY)
	private List<DepartmentEmployee> departments;
	
	@OneToMany(mappedBy="salaryPK.employee", fetch=FetchType.LAZY)
	private List<Salary> salaries;
	
	@Id
	@Column(name="emp_no")
	private int empNo;
	
	@Column(name="birth_date")
	private Date birthDate;
	
	@Column(name="hire_date")
	private Date hireDate;
	
	@Column(name="gender")
	private char gender;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	public int getEmpNo() {
		return empNo;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public char getGender() {
		return gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<DepartmentEmployee> getDepartments() {
		return departments;
	}

	public void setDepartments(List<DepartmentEmployee> departments) {
		this.departments = departments;
	}

	public List<Salary> getSalaries() {
		return salaries;
	}

	public void setSalaries(List<Salary> salaries) {
		this.salaries = salaries;
	}
	
	
}
