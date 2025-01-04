package com.jthread.employeemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jthread.employeemanagement.dto.EmployeesInDepartmentDto;
import com.jthread.employeemanagement.exception.ResourceNotFoundException;
import com.jthread.employeemanagement.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository departmnetRepository;
	
	@Override
	public List<EmployeesInDepartmentDto> findEmployeesInDepartment(String departmentName) throws ResourceNotFoundException {

		
		 List<EmployeesInDepartmentDto> results =departmnetRepository.findEmployeesInDepartment(departmentName);
			if (results.isEmpty()) {
				throw new ResourceNotFoundException("Department not found");
			}
            return results;

	}
}
