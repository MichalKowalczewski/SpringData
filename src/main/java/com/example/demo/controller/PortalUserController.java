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
        System.out.println(portalUserRepository.getData(5).getLastName());
        portalUserRepository.findByLastNameStartsWith("N").forEach(portalUser -> System.out.println(portalUser.getFirstName()));
        return "home";
    }
}
