package com.example.hrms.dataAccess.abstracts;


import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
}