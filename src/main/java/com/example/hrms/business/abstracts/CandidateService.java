package com.example.hrms.business.abstracts;

import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.Employer;
import com.example.hrms.entities.concretes.JobTitle;

import java.time.LocalDate;
import java.util.List;

public interface CandidateService {
    DataResult<List<Candidate>> getAll();
    Result register(Candidate candidate);


    //DataResult<Boolean> isPersonReal(String nationalityId, String firstName, String lastName, int birtOfYear);

//    DataResult<Boolean> isPersonReal(String nationalityId, String firstName, String lastName, int birtOfYear);

}