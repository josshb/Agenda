/**
 * 
 */
package com.josem.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.josem.entity.Contact;

/**
 * @author jozee
 *
 */
@Repository("contactRepository")
public interface ConctacRepository extends JpaRepository<Contact, Serializable>{
	
	public Contact findById(int id);
}
