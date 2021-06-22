package com.example.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Employer;
import com.example.hrms.entities.concretes.User;

import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> getAll();


    Result register(Employer employer);

    Result saveImage(MultipartFile file, int empId);
}
