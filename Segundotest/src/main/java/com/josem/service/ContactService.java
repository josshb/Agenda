/**
 * 
 */
package com.josem.service;

import java.util.List;

import com.josem.entity.Contact;
import com.josem.model.ContactUsers;

/**
 * @author jozee
 *
 */
public interface ContactService{

	public ContactUsers addContact(ContactUsers contactUser);
	
	public List<ContactUsers> listAllContacts();
	
	public Contact findContactById(int id);
	
	public void removeContact (int id);
	
	public ContactUsers findContactByIdModel(int id);
}
