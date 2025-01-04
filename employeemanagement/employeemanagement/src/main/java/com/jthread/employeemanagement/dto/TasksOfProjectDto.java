package com.jthread.employeemanagement.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TasksOfProjectDto {

	private Integer taskId;
	private String taskName;
	private LocalDate deadline;

	public TasksOfProjectDto() {
	}
	
	public TasksOfProjectDto(Integer taskId, String taskName, LocalDate deadline) {
		this.taskId = taskId;
		this.taskName = taskName;
		this.deadline = deadline;
	}


}
