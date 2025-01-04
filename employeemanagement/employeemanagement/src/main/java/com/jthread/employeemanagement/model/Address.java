package com.jthread.employeemanagement.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address")
@NoArgsConstructor
@Getter
@Setter
public class Address {
	
	@Id
	@GeneratedValue (strategy =  GenerationType.IDENTITY)
	private Integer addressId;
	private String street;
	private String city;
	private String state;
	private Integer zipCode;
	
	@OneToOne(mappedBy = "adress", cascade = CascadeType.ALL)
	private Employee employee;
	
	public Address(String street, String city, String state, Integer zipCode) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	public Address(String street, String city, String state, Integer zipCode, Employee employee) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", zipCode=" + zipCode + ", employee=" + employee + "]";
	}
	
	
	

}
