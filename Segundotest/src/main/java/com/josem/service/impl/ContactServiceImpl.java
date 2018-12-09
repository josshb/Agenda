/**
 * 
 */
package com.josem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.josem.component.ContactConverter;
import com.josem.entity.Contact;
import com.josem.model.ContactUsers;
import com.josem.repository.ConctacRepository;
import com.josem.service.ContactService;

/**
 * @author jozee
 *
 */
@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {

	@Autowired
	@Qualifier("contactRepository")
	private ConctacRepository contactRepository;

	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.josem.service.ContactService#addContact(com.josem.model.ContactUsers)
	 */
	public ContactUsers addContact(ContactUsers contactUser) {
		Contact contact = contactRepository.save(contactConverter.convertContatUser2Contact(contactUser));
		return contactConverter.convertContatc2ContactUser(contact);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.josem.service.ContactService#listAllContacts()
	 */
	@Override
	public List<ContactUsers> listAllContacts() {
		List<Contact> contacts = contactRepository.findAll();
		List<ContactUsers> contactsUser = new ArrayList<ContactUsers>();
		for (Contact contact : contacts)
			contactsUser.add(contactConverter.convertContatc2ContactUser(contact));
		return contactsUser;
	}

	/* (non-Javadoc)
	 * @see com.josem.service.ContactService#findContactById(int)
	 */
	@Override
	public Contact findContactById(int id) {
		
		return contactRepository.findById(id);
	}
	public ContactUsers findContactByIdModel(int id) {
		return contactConverter.convertContatc2ContactUser(findContactById(id));
	}
	/* (non-Javadoc)
	 * @see com.josem.service.ContactService#removeContact(com.josem.entity.Contact)
	 */
	@Override
	public void removeContact(int id) {
		
		Contact contact=findContactById(id);
		if (contact!=null) {
			contactRepository.delete(contact);
			
		}
	}
	

}
