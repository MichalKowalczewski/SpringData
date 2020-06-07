package com.example.demo.service;

import com.example.demo.model.PortalUser;
import com.example.demo.model.Role;
import com.example.demo.repository.PortalUserRepository;
import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PortalUserServiceImpl implements PortalUserService {

    @Autowired
    PortalUserRepository portalUserRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void createNewUser(PortalUser portalUser) {
        portalUser.setPassword(passwordEncoder.encode(portalUser.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("USER"));
        portalUser.setRoles(roles);
        portalUserRepository.save(portalUser);
    }
}
