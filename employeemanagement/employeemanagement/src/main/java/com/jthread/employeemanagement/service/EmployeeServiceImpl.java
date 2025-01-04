package com.jthread.employeemanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jthread.employeemanagement.dto.EmployeeInCityDto;
import com.jthread.employeemanagement.dto.EmployeesInDepartmentDto;
import com.jthread.employeemanagement.dto.ProjectsDto;
import com.jthread.employeemanagement.exception.ResourceNotFoundException;
import com.jthread.employeemanagement.model.Address;
import com.jthread.employeemanagement.model.Department;
import com.jthread.employeemanagement.model.Employee;
import com.jthread.employeemanagement.model.Project;
import com.jthread.employeemanagement.model.Task;
import com.jthread.employeemanagement.repository.AddressRepository;
import com.jthread.employeemanagement.repository.DepartmentRepository;
import com.jthread.employeemanagement.repository.EmployeeRepository;
import com.jthread.employeemanagement.repository.ProjectRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired 
	private EmployeeRepository employeeRepository; 
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	


	@Override
	public List<ProjectsDto> getProjectsByEmployeeId(Integer employeeId) throws ResourceNotFoundException {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		List<ProjectsDto> results = new ArrayList<ProjectsDto>();
		if (!employee.isPresent()) {
			throw new ResourceNotFoundException("Employee not found");
		}
		else {
			 results=employeeRepository.getProjectsByEmployeeId(employeeId);
		}
		
		return results;
	}



	@Override
	public List<EmployeeInCityDto> getEmployeeInCity(String city) throws ResourceNotFoundException {
		List<EmployeeInCityDto> employeeList=	addressRepository.getEmployeeInCity(city);
		if(employeeList.isEmpty()) {
            throw new ResourceNotFoundException("No employee found in city : " + city);
        }
		return employeeList;
	}



	@Override
	public Integer getProjectBudgetbyEmployeeId(Integer employeeId) throws ResourceNotFoundException {
		Integer budget=projectRepository.getProjectBudgetbyEmployeeId(employeeId);
		if(budget==null) 
            throw new ResourceNotFoundException("No project found for employee id : " + employeeId);
		return budget;
	
	}


	
}

	