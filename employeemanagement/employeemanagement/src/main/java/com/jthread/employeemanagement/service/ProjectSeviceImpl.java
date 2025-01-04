package com.jthread.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jthread.employeemanagement.dto.TasksOfProjectDto;
import com.jthread.employeemanagement.exception.ResourceNotFoundException;
import com.jthread.employeemanagement.model.Project;
import com.jthread.employeemanagement.repository.ProjectRepository;

@Service
public class ProjectSeviceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public List<TasksOfProjectDto> getTasksByProjectId(Integer projectId) throws ResourceNotFoundException {
		Optional<Project> projectContainer = projectRepository.findById(projectId);
		if (projectContainer.isPresent()) {
			Project project = projectContainer.get();
            return projectRepository.getTasksByProjectId(project.getProjectId());
		}
         else {
        	 throw new ResourceNotFoundException("Project not found");
         }
	}

}
