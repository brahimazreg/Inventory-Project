package com.qa;


/**
*
* @author brahim
*/
/**
 * This is  the customer class. 
 * 
 * 
 */
public class Customer {
	/**
	 * @id identify a record in customer table.. 
	 * 
	 * 
	 */

	private Long id;
	/**
	 * @firstName the first name of a customer. 
	 * 
	 * 
	 */
	private String firstName;
	/**
	 * @surName the surname of a customer. 
	 * 
	 * 
	 */
	private String surName;
	
	/**
	 *the constructor to initialize variabls'class
	 * 
	 * 
	 */
	public Customer(Long id, String firstName, String surname) {
		this.id = id;
		this.firstName = firstName;
		this.surName = surname;
		
	}
	/**
	 *Return the id of the customer
	 * 
	 * 
	 */
	public Long getId() {
		return id;
	}
	/**
	 *Assign a value to the id.
	 * 
	 * 
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * Return the firstName of a customer.
	 * 
	 * 
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * set the set FirstName to a customer.
	 * 
	 * 
	 */
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * return the value of the customer.
	 * 
	 * 
	 */
	public String getSurName() {
		return surName;
	}
	/**
	 * set a value to surname of the customer.
	 * 
	 * 
	 */
	public void setSurName(String surName) {
		this.surName = surName;
	}
    

}  
