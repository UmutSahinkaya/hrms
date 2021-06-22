package com.example.hrms.business.concretes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hrms.business.abstracts.SchoolGradeService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.SchoolGradeDao;
import com.example.hrms.entities.concretes.SchoolGrade;

import java.util.List;


@Service
public class SchoolGradeManager implements SchoolGradeService {

    private SchoolGradeDao schoolGradeDao;


    @Autowired
    public SchoolGradeManager(SchoolGradeDao schoolGradeDao){
        this.schoolGradeDao = schoolGradeDao;
    }

    @Override
    public DataResult<List<SchoolGrade>> getAll() {
        return new SuccessDataResult<List<SchoolGrade>>
                (this.schoolGradeDao.findAll(),"Başarı ile Getirildi - School Grades");
    }

    @Override
    public Result add(SchoolGrade schoolGrade) {
        this.schoolGradeDao.save(schoolGrade);
        return new SuccessResult("Başarı ile Eklendi");
    }
}
