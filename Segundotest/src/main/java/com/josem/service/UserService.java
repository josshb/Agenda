/**
 * 
 */
package com.josem.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.josem.model.User;
import com.josem.model.UserRoles;
import com.josem.repository.RoleRepository;
import com.josem.repository.UserRepository;

/**
 * @author jozee
 *
 */
@Service("userService")
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncode;
    /**
     * @param userRepository
     * @param roleRepository
     * @param passwordEncode
     */
    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository,
	    BCryptPasswordEncoder passwordEncode) {
	super();
	this.userRepository = userRepository;
	this.roleRepository = roleRepository;
	this.passwordEncode = passwordEncode;
    }
    
    public User findUserByEmail(String email) {
	return userRepository.findByEmail(email);
	
    }
    
    public void saveUser(User user) {

	user.setPassword(passwordEncode.encode(user.getPassword()));
	user.setActive(1);
	UserRoles userRole= roleRepository.findByRole("ADMIN");
	user.setRoles(new HashSet<UserRoles>(Arrays.asList(userRole)));
	userRepository.save(user);
	
    }
    
    
}
