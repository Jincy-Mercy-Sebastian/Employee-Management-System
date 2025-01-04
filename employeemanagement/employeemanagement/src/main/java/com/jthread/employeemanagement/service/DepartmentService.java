package com.jthread.employeemanagement.service;

import java.util.List;

import com.jthread.employeemanagement.dto.EmployeesInDepartmentDto;
import com.jthread.employeemanagement.exception.ResourceNotFoundException;

public interface DepartmentService {
	public List<EmployeesInDepartmentDto> findEmployeesInDepartment(String departmentName) throws ResourceNotFoundException;

}
