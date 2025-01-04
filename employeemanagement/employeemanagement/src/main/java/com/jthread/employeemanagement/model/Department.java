package com.jthread.employeemanagement.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="department")
@NoArgsConstructor
@Getter
@Setter
public class Department {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer departmentId;
	private String name;
	private String location;
	
	@OneToMany( mappedBy = "department", cascade = CascadeType.ALL)
	private Set<Employee> employee;
	
	public Department(String name, String location) {
		this.name = name;
		this.location = location;
	}

	public Department(String name, String location, Set<Employee> employee) {
		super();
		this.name = name;
		this.location = location;
		this.employee = employee;
	}
	
//	toString() method
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", name=" + name + ", location=" + location + "]";
	}
	

}
