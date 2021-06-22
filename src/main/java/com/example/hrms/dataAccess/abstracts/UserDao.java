package com.example.hrms.dataAccess.abstracts;

import  org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.hrms.entities.concretes.User;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    boolean existsByEmail(String mail);
}
