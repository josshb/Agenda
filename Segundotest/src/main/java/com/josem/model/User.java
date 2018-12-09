/**
 * 
 */
package com.josem.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import lombok.Data;

/**
 * @author jozee
 *
 */
@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    @Column(name = "email")
    @Email(message = "*please provide an email")
    @NotEmpty(message = "*please provida a valid email")
    private String email;
    @Column(name = "password")
    @Length(min = 5, message = "your password must have at least 5 characters")
    @NotEmpty(message = "please enter your password")
    private String password;
    @Column(name="name")
    @NotEmpty(message="please enter your name")
    private String name;
    @Column(name="last_name")
    @NotEmpty(message="please enter your last name")
    private String lastName;
    @Column(name="active")
    private int active;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="user_role", joinColumns=@JoinColumn(name="user_id"), 
    inverseJoinColumns=@JoinColumn(name="role_id"))
    private Set<UserRoles> roles;
    
}
