package com.example.hrms.dataAccess.abstracts;


import com.example.hrms.entities.concretes.Candidate;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {

    boolean existsByIdentityNumber(String identityNumber);

}
