package com.jthread.employeemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmployeesInDepartmentDto {
	private Integer employeeId;
	private String firstName;
	private String lastName;
	private String email;
	
	private Integer departmentId;
	private String departmentName;
	
	
	
	

}
