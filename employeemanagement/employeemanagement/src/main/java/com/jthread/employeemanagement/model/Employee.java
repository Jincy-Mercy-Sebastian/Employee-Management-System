package com.jthread.employeemanagement.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="employee")
@NoArgsConstructor
//@Getter
//@Setter
public class Employee {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private Integer salary;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn( name="deparment_id", referencedColumnName = "departmentId" )
	private Department department;
	
	
	@ManyToMany
	@JoinTable(
			name = "employee_project",
			joinColumns = @JoinColumn( name = "empIdfk"),
			inverseJoinColumns = @JoinColumn( name = "projectIdfk"))	
	private Set<Project> projects;
	
	@OneToOne( cascade = CascadeType.ALL)
	@JoinColumn( name = "address", referencedColumnName = "addressId")
	private Address adress;
	
	public Employee(String firstName, String lastName, String email, Integer salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.salary = salary;
	}

	public Employee( String firstName, String lastName, String email, Integer salary,
			Address adress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.salary = salary;
		this.adress = adress;
	}

	public Employee(String firstName, String lastName, String email, Integer salary, Department department,
			Set<Project> projects, Address adress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.salary = salary;
		this.department = department;
		this.projects = projects;
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", salary=" + salary + ", department=" + department + ", projects=" + projects + ", adress="
				+ adress + "]";
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public Integer getSalary() {
		return salary;
	}

	public Department getDepartment() {
		return department;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public Address getAdress() {
		return adress;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}
	
	
	
	
	
}
