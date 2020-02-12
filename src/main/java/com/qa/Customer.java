package com.qa;


/**
*
* @author brahim
*/

public class Customer {


	private Long id;
	private String firstName;
	private String surName;
	
	
	public Customer(Long id, String firstName, String surname) {
		this.id = id;
		this.firstName = firstName;
		this.surName = surname;
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
    

}  
