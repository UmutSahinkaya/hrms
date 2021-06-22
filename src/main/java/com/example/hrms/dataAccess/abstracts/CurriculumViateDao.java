package com.example.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.hrms.entities.concretes.CurriculumViate;
import com.example.hrms.entities.dtos.CvDto;

import java.util.List;

public interface CurriculumViateDao extends JpaRepository<CurriculumViate,Integer> {

    @Query("From CurriculumVitae where candidate_Id=:id")
    List<CurriculumViate> getByCandidate_Id(int id);




}