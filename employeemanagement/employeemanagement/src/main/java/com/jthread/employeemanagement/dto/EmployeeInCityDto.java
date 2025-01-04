package com.jthread.employeemanagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeInCityDto {
	private String firstName;
	private String lastName;
	private String city;

	public EmployeeInCityDto(String firstName, String lastName, String city) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
	}

	@Override
	public String toString() {
		return "EmployeeInCityDto [firstName=" + firstName + ", lastName=" + lastName + ", city=" + city + "]";
	}

}
