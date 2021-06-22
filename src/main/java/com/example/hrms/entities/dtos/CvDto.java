package com.example.hrms.entities.dtos;
import com.example.hrms.entities.concretes.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.hrms.entities.concretes.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {
    //@JsonIgnoreProperties({"password"})
    private Candidate candidateId;

    private List<EduHistory> eduHistories;

    private List<JobExperience> jobExperiences;

    private List<Talent> talents;

    private List<Language> languages;

    private String  photo;
}