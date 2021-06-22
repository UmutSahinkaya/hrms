package com.example.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hrms.entities.concretes.SchoolGrade;
import com.example.hrms.entities.concretes.Talent;

import java.util.List;

public interface TalentDao extends JpaRepository<Talent,Integer> {

}