package com.jthread.employeemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jthread.employeemanagement.dto.EmployeeInCityDto;
import com.jthread.employeemanagement.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{
	

	@Query("SELECT new com.jthread.employeemanagement.dto.EmployeeInCityDto(e.firstName, e.lastName, a.city) "
			+ "FROM Address a JOIN a.employee e WHERE a.city = :city")	
	public List<EmployeeInCityDto> getEmployeeInCity(@Param("city") String city);


}
