package com.jthread.employeemanagement.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "project")
@NoArgsConstructor
@Getter
@Setter
public class Project {
	
	@Id
	@GeneratedValue (strategy =  GenerationType.IDENTITY)
	private Integer projectId;
	private String projectName;
	private Integer budget;
	
	@ManyToMany( mappedBy = "projects")
	private Set<Employee> employees;
	
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	private Set<Task> tasks;
	
	public Project(String projectName, Integer budget) {
		this.projectName = projectName;
		this.budget = budget;
	}

	public Project(Integer projectId, String projectName, Integer budget, Set<Employee> employees) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.budget = budget;
		this.employees = employees;
	}

	public Project(String projectName, Integer budget, Set<Task> tasks) {
		this.projectName = projectName;
		this.budget = budget;
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", budget=" + budget
				+ ", employees=" + employees + ", tasks=" + tasks + "]";
	}
	
	

}
