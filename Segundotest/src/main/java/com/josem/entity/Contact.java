/**
 * 
 */
package com.josem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author jozee
 *
 */
@Data
@Entity
@Table(name = "contact")
public class Contact {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "firstname")
	private String firstname;
	@Column(name = "lastname")
	private String lastname;
	@Column(name = "telephone")
	private long telephone;
	@Column(name = "city")
	private String city;

	public Contact() {

	}

	/**
	 * @param firstname
	 * @param lastname
	 * @param telephone
	 * @param city
	 */
	public Contact(String firstname, String lastname, long telephone, String city, int id) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.telephone = telephone;
		this.city = city;
		this.id = id;

	}

}
