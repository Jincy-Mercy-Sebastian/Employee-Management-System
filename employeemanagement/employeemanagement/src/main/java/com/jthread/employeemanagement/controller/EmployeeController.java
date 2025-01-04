package com.jthread.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jthread.employeemanagement.dto.EmployeeInCityDto;
import com.jthread.employeemanagement.dto.EmployeesInDepartmentDto;
import com.jthread.employeemanagement.dto.ProjectsDto;
import com.jthread.employeemanagement.dto.TasksOfProjectDto;
import com.jthread.employeemanagement.exception.ResourceNotFoundException;
import com.jthread.employeemanagement.model.Project;
import com.jthread.employeemanagement.model.Task;
import com.jthread.employeemanagement.service.DepartmentService;
import com.jthread.employeemanagement.service.EmployeeService;
import com.jthread.employeemanagement.service.ProjectService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmnetService;
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/getEmployeesWithDepartment")
	public List<EmployeesInDepartmentDto> findEmployeeInDepartment(@RequestParam String departmentName) throws ResourceNotFoundException{
		return departmnetService.findEmployeesInDepartment(departmentName);
	}
	
	@GetMapping("/getProjectsByEmployeeId")
	public List<ProjectsDto> getProjectsByEmployeeId(@RequestParam Integer employeeId) throws ResourceNotFoundException{
		return employeeService.getProjectsByEmployeeId(employeeId);
	}
	
	@GetMapping("/getTasksByProjectId")
	public List<TasksOfProjectDto> getTasksByProjectId(@RequestParam Integer projectId) throws ResourceNotFoundException {
		return projectService.getTasksByProjectId(projectId);
	}
	
	@GetMapping("/getEmployeesByCity")
	public List<EmployeeInCityDto> getEmployeesByCity(@RequestParam String city) throws ResourceNotFoundException{
		return employeeService.getEmployeeInCity(city);
	}
	
	@GetMapping("/getProjectBudgetByEmployeeId")
	public Integer getProjectBudgetByEmployeeId(@RequestParam Integer employeeId) throws ResourceNotFoundException {
		return employeeService.getProjectBudgetbyEmployeeId(employeeId);
	}

}
