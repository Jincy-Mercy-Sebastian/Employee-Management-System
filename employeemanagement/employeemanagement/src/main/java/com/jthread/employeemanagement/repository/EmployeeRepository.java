package com.jthread.employeemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jthread.employeemanagement.dto.ProjectsDto;
import com.jthread.employeemanagement.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	    
	    @Query("SELECT new com.jthread.employeemanagement.dto.ProjectsDto(p.projectId, p.projectName)" + 
	    		"FROM Project p JOIN p.employees e WHERE e.id = :employeeId")
	    List<ProjectsDto> getProjectsByEmployeeId(Integer employeeId);
	
	   


}												
