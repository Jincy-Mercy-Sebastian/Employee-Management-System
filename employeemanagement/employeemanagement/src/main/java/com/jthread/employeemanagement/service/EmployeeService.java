package com.jthread.employeemanagement.service;

import java.util.List;

import com.jthread.employeemanagement.dto.EmployeeInCityDto;
import com.jthread.employeemanagement.dto.ProjectsDto;
import com.jthread.employeemanagement.exception.ResourceNotFoundException;


public interface EmployeeService {

	public List<ProjectsDto> getProjectsByEmployeeId(Integer employeeId) throws ResourceNotFoundException;
	
	public List<EmployeeInCityDto> getEmployeeInCity(String city) throws ResourceNotFoundException;
	
	public Integer getProjectBudgetbyEmployeeId(Integer employeeId) throws ResourceNotFoundException;
	

}
