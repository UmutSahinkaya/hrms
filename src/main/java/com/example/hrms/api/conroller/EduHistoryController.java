package com.example.hrms.api.conroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.hrms.business.abstracts.EduHistoryService;
import com.example.hrms.business.concretes.EduHistoryManager;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.EduHistory;
import com.example.hrms.entities.concretes.Talent;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/eduHistory")
public class EduHistoryController {

    private EduHistoryService eduHistoryService;

    @Autowired
    public EduHistoryController(EduHistoryService eduHistoryService){
        this.eduHistoryService = eduHistoryService;
    }

    @GetMapping("/getall")
    public DataResult<List<EduHistory>> getAll(){
        return this.eduHistoryService.getAll();
    }


    @PostMapping("/add")
    public Result add(@Valid @RequestBody EduHistory eduHistory) {
        return this.eduHistoryService.add(eduHistory);
    }
}