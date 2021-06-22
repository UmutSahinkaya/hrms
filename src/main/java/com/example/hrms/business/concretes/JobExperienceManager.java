package com.example.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hrms.business.abstracts.JobExperienceService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.JobExperienceDao;
import com.example.hrms.entities.concretes.JobExperience;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobExperienceManager implements JobExperienceService {

    private JobExperienceDao jobExperienceDao;

    @Autowired
    public JobExperienceManager(JobExperienceDao jobExperienceDao){
        this.jobExperienceDao = jobExperienceDao;
    }


    @Override
    public Result add(JobExperience jobExperience) {
        jobExperience.setCreatedDate(LocalDate.now());
        this.jobExperienceDao.save(jobExperience);
        return new SuccessResult("Başarı ile Eklendi");
    }

    @Override
    public DataResult<List<JobExperience>> getAll() {
        return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll(),"Başarı İle Getirildi - Jobexperience");
    }
}