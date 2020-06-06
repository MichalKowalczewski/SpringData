package com.example.demo.repository;

import com.example.demo.model.PortalUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortalUserRepository extends JpaRepository<PortalUser, Integer> {
}
