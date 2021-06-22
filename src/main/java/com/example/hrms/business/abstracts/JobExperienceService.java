package com.example.hrms.business.abstracts;


import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobExperience;

import java.util.List;

public interface JobExperienceService {
    Result add(JobExperience jobExperience);
    DataResult<List<JobExperience>> getAll();
}