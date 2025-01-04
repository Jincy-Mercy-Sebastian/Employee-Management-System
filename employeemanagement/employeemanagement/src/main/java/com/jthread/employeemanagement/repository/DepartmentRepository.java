package com.jthread.employeemanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jthread.employeemanagement.dto.EmployeesInDepartmentDto;
import com.jthread.employeemanagement.model.Department;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

	Department findByName(String departmentName);
	
    @Query("SELECT new com.jthread.employeemanagement.dto.EmployeesInDepartmentDto(e.id, e.firstName, e.lastName, e.email, d.id, d.name) " +
	           "FROM Employee e JOIN e.department d WHERE d.name = :departmentName")
	 List<EmployeesInDepartmentDto> findEmployeesInDepartment(@Param("departmentName") String departmentName);
	    

}
