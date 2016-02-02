package employees.it.matteoavanzini.examples.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="departments")
public class Department {
	
	@OneToMany(mappedBy="departmentEmployeePK.department", fetch=FetchType.LAZY)
	private List<DepartmentEmployee> employees;
	
	@OneToMany(mappedBy="departmentEmployeePK.department", fetch=FetchType.LAZY)
	private List<DepartmentManager> manager;
	
	@Id
	@Column(name="dept_no", columnDefinition="char(4)")
	private String deptNo;
	
	@Column(name="dept_name")
	private String deptName;

	public String getDeptNo() {
		return deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
}
