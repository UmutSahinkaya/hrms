package com.example.hrms.business.abstracts;


import org.springframework.web.multipart.MultipartFile;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.Employer;
import com.example.hrms.entities.concretes.JobAdvertisement;
import com.example.hrms.entities.dtos.JobAdvertisementDto;

import javax.xml.crypto.Data;
import java.util.List;

public interface JobAdvertisementService {
    DataResult<List<JobAdvertisement>> getAll();

    DataResult<List<JobAdvertisement>> getAllStatusTrue();

    DataResult<JobAdvertisement> getByJobAdvertisementId(int jobAdvertisementId);

    DataResult<List<JobAdvertisement>> findAllByEmployer_IdAndStatusTrue(int employerId);

    Result saveImage(MultipartFile file, int jobAdvertisementId);

    Result add(JobAdvertisement jobAdvertisement);

    Result findById(int jobAdvertisementId,boolean status);

    DataResult<List<JobAdvertisement>> findAllByStatusTrueSortedAsc();

    DataResult<List<JobAdvertisement>> findAllByStatusTrueOrderByPublishDateDesc();


    DataResult<List<JobAdvertisementDto>> getJobAdvertisementWithEmpDetails();

    DataResult<List<JobAdvertisementDto>> getJobAdvertisementWithEmpDetailsSıralamaAsc();

    DataResult<List<JobAdvertisementDto>> getJobAdvertisementWithEmpDetailsByEmpId(int employerId);
}