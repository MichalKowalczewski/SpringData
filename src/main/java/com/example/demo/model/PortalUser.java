package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="portal_user")
@Data
public class PortalUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PU_ID")
    private int id;
    @Column(name="PU_LOGIN")
    private String login;
    @Column(name="PU_FIRSTNAME")
    private String firstName;
    @Column(name="PU_LASTNAME")
    private String lastName;
    @Column(name="PU_EMAIL")
    private String email;
    @Column(name="PU_PASSWORD")
    private String password;

}
