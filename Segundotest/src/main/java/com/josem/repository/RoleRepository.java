/**
 * 
 */
package com.josem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josem.model.UserRoles;

/**
 * @author jozee
 *
 */
public interface RoleRepository extends JpaRepository<UserRoles, Integer> {
    UserRoles findByRole (String Role);
    
}
