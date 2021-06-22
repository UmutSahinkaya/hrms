package com.example.hrms.api.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.hrms.business.abstracts.JobExperienceService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobExperience;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/jobExperience")
public class JobExperienceController {

    private JobExperienceService jobExperienceService;

    @Autowired
    public JobExperienceController(JobExperienceService jobExperienceService){
        this.jobExperienceService = jobExperienceService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobExperience>> getAll(){
        return this.jobExperienceService.getAll();
    }


    @PostMapping("/add")
    public Result add(@Valid @RequestBody JobExperience jobExperience) {
        return this.jobExperienceService.add(jobExperience);
    }

}