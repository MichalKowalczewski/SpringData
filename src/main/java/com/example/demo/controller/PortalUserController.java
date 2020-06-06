package com.example.demo.controller;

import com.example.demo.repository.PortalUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortalUserController {

    @Autowired
    PortalUserRepository portalUserRepository;

    @GetMapping("/home")
    public String homePage(){
        portalUserRepository.findByFirstName("Maria").forEach(portalUser -> System.out.println(portalUser.getFirstName()));
        return "home";
    }
}
