package com.example.demo.repository;

import com.example.demo.model.PortalUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortalUserRepository extends JpaRepository<PortalUser, Integer> {

    List<PortalUser> findByFirstName(String firstName);

    List<PortalUser> findByLastNameStartsWith(String lastName);

    @Query("select pu from PortalUser pu where pu.id=?1")
    PortalUser getData(int id);

    Page<PortalUser> findAll(Pageable pageable);

    PortalUser findByLogin(String login);


}
