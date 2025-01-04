package com.jthread.employeemanagement.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "task")
@NoArgsConstructor
@Getter
@Setter
public class Task {
	
	@Id
	@GeneratedValue (strategy =  GenerationType.IDENTITY)
	private Integer taskId;
	private String taskName;
	private LocalDate deadline;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "project_id", referencedColumnName = "projectId")
	private Project project;
	
	public Task(String taskName, LocalDate deadline) {
		this.taskName = taskName;
		this.deadline = deadline;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", deadline=" + deadline + ", project=" + project
				+ "]";
	}
	

	
}
