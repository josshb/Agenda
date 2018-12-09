/**
 * 
 */
package com.josem.component;

import org.springframework.stereotype.Component;

import com.josem.entity.Contact;
import com.josem.model.ContactUsers;

/**
 * @author jozee
 *
 */
@Component("contactConverter")
public class ContactConverter {

	public Contact convertContatUser2Contact(ContactUsers contactUsers) {
		Contact contact = new Contact();
		contact.setId(contactUsers.getId());
		contact.setFirstname(contactUsers.getFirstname());
		contact.setLastname(contactUsers.getLastname());
		contact.setTelephone(contactUsers.getTelephone());
		contact.setCity(contactUsers.getCity());
		return contact;
	}

	public ContactUsers convertContatc2ContactUser(Contact contact) {
		ContactUsers cu=new ContactUsers();
		cu.setId(contact.getId());
		cu.setFirstname(contact.getFirstname());
		cu.setLastname(contact.getLastname());
		cu.setTelephone(contact.getTelephone());
		cu.setCity(contact.getCity());
		return cu;
		
	}

}
