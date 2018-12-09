/**
 * 
 */
package com.josem.controller;


import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.josem.model.User;
import com.josem.service.UserService;

import lombok.extern.apachecommons.CommonsLog;

/**
 * @author jozee
 *
 */
@CommonsLog(topic="LoginControler")
@Controller
public class LoginControler {
	
	
	
	@Autowired
	private UserService userService;

	@GetMapping({ "/", "/login" })
	public ModelAndView login() {
		log.info("Login");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}

	@GetMapping("/registration")
	public ModelAndView registration() {
		ModelAndView mv = new ModelAndView();
		User user = new User();
		mv.addObject("user", user);
		mv.setViewName("registration");
		return mv;
	}

	@PostMapping("/registration")
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());

		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user", "error con el usuario que ya hay alghien asi premoh");

		}
		if (bindingResult.hasErrors()) {
			mv.setViewName("registration");
		} else {
			userService.saveUser(user);
			mv.addObject("succesMessage", "User añadio bien");
			mv.addObject("user", new User());
			mv.setViewName("registration");
		}
		return mv;
	}

	 @RequestMapping(value="/admin/home1", method = RequestMethod.GET)
	    public ModelAndView home(){
	        ModelAndView modelAndView = new ModelAndView();
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        User user = userService.findUserByEmail(auth.getName());
	        modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
	        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
	        modelAndView.setViewName("admin/home1/");
	        return modelAndView;
	}
}
