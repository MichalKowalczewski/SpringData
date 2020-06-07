package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name="portal_user")
@Data
public class PortalUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PU_ID")
    private int id;
    @Column(name="PU_LOGIN")
    @NotEmpty
    private String login;
    @NotEmpty
    @Column(name="PU_FIRSTNAME")
    private String firstName;
    @NotEmpty
    @Column(name="PU_LASTNAME")
    private String lastName;
    @NotEmpty
    @Email
    @Column(name="PU_EMAIL")
    private String email;
    @Column(name="PU_PASSWORD")
    @Size(min = 7)
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name= "portal_user_roles", joinColumns = @JoinColumn(name = "PUR_PU_ID"),
            inverseJoinColumns = @JoinColumn(name="PUR_RO_ID"))
    private Set<Role> roles;

}
