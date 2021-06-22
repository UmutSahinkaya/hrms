package com.example.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.CurriculumViate;

import java.util.List;

public interface CurriculumViateService {
    DataResult<List<CurriculumViate>> getAll();

    Result add(CurriculumViate curriculumViate);

    Result saveImage(MultipartFile file, int cvId);

    DataResult<List<CurriculumViate>> getByCandidateId(int id);

}
