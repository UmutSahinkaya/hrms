package com.example.hrms.api.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.hrms.business.abstracts.EmployerService;
import com.example.hrms.business.abstracts.SchoolGradeService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Employer;
import com.example.hrms.entities.concretes.SchoolGrade;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/SchoolGrade")
public class SchoolGradeController {


    private SchoolGradeService schoolGradeService;

    @Autowired
    public SchoolGradeController(SchoolGradeService schoolGradeService) {
        this.schoolGradeService = schoolGradeService;
    }

    @GetMapping("/getall")
    public DataResult<List<SchoolGrade>> getAll(){
        return this.schoolGradeService.getAll();
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody SchoolGrade schoolGrade){
        return this.schoolGradeService.add(schoolGrade);

    }
}