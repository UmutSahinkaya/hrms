package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.SchoolGrade;

import java.util.List;


public interface SchoolGradeService {

    DataResult<List<SchoolGrade>> getAll();

    Result add(SchoolGrade schoolGrade);


}
