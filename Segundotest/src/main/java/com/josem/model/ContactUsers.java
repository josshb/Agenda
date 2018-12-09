/**
 * 
 */
package com.josem.model;


import lombok.Data;

/**
 * @author jozee
 *
 */
@Data
public class ContactUsers {
	private int id;
	private String firstname;
	private String lastname;
	private long telephone;
	private String city;
	/**
	 * @param id
	 * @param firstname
	 * @param lastname
	 * @param telephone
	 * @param city
	 */
	public ContactUsers(int id, String firstname, String lastname, long telephone, String city) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.telephone = telephone;
		this.city = city;
	}
	public ContactUsers() {
		
	}
	
}
