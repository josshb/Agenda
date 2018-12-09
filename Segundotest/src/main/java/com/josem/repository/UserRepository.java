/**
 * 
 */
package com.josem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.josem.model.User;


/**
 * @author jozee
 *
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, User> {
    
    User findByEmail(String Email);
    

    
    
}
