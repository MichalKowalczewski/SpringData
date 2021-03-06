package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.model.PortalUser;
import com.example.demo.repository.PortalUserRepository;
import com.example.demo.service.PortalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class PortalUserController {

    @Autowired
    PortalUserRepository portalUserRepository;

    @Autowired
    PortalUserService portalUserService;

    @GetMapping("/home")
    public String homePage(){
        System.out.println(portalUserRepository.getData(5).getLastName());
        portalUserRepository.findByLastNameStartsWith("N").forEach(portalUser -> System.out.println(portalUser.getFirstName()));
        return "home";
    }

    @GetMapping("/users")
    public String getUsers(
            Model model,
            @RequestParam("page")Optional<Integer> page,
            @RequestParam("size")Optional<Integer> size
            ){
        int currentPage = page.orElse(1);
        int currentSize = size.orElse(2);

        Page<PortalUser> portalUsersPage = portalUserRepository.findAll(PageRequest.of(currentPage-1, currentSize));
        model.addAttribute("portalUsersPage", portalUsersPage);

        int totalPages = portalUsersPage.getTotalPages();
        if (totalPages > 0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "users";
    }

    @GetMapping("/login")
    public String login(){
        return "/login";
    }

    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("portalUser", new PortalUser());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid PortalUser portalUser, BindingResult result){
        if (result.hasErrors()){
            return "register";
        }
        else {
            portalUserService.createNewUser(portalUser);
            return "redirect:/login";
        }

    }




}
