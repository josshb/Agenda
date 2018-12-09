/**
 * 
 */
package com.josem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.josem.constant.ViewConstant;
import com.josem.entity.Contact;
import com.josem.model.ContactUsers;
import com.josem.service.ContactService;

/**
 * @author jozee
 *
 */
@Controller("contactController")
@RequestMapping("/admin/home1")
public class ContactController {

	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactServices;

	@GetMapping("/cancel ")
	public String cancel() {
		return ViewConstant.CONTACTS;
	}

	@GetMapping("contactform")
	private String redirectContactForm(@RequestParam(name = "id", required = true) int id, Model model) {

		ContactUsers contact = new ContactUsers();

		if (id != 0) {

			contact = contactServices.findContactByIdModel(id);

		}

		model.addAttribute("contactModel", contact);

		return ViewConstant.CONTACT_FORM;

	}

	@PostMapping("addcontact")
	public String addContact(@ModelAttribute(name = "contactModel") ContactUsers contactModel, Model model) {

		
				
		if (null != contactServices.addContact(contactModel)) {
			model.addAttribute("result", 1);
		}else
			model.addAttribute("result", 0);
		
		return "redirect:/admin/home1/";

	}

	@GetMapping("/")
	public ModelAndView showContacts() {
		ModelAndView mv = new ModelAndView(ViewConstant.CONTACTS);
		mv.addObject("contacts", contactServices.listAllContacts());
		return mv;

	}

	@GetMapping("removecontact")
	public ModelAndView removeContact(@RequestParam(name = "id", required = true) int id) {
		contactServices.removeContact(id);
		return showContacts();
	}

}
