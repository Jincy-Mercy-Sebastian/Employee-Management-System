package com.jthread.employeemanagement.service;

import java.util.List;

import com.jthread.employeemanagement.dto.TasksOfProjectDto;
import com.jthread.employeemanagement.exception.ResourceNotFoundException;
import com.jthread.employeemanagement.model.Task;

public interface ProjectService {
	
	public List<TasksOfProjectDto> getTasksByProjectId(Integer projectId) throws ResourceNotFoundException;

}
