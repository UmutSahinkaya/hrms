package com.example.hrms.api.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.hrms.business.abstracts.TalentService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Talent;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/talent")
public class TalentController {

    private TalentService talentService;

    @Autowired
    public TalentController(TalentService talentService){
        this.talentService = talentService;
    }
    @GetMapping("/getall")
    public DataResult<List<Talent>> getAll(){
        return this.talentService.getAll();
    }


    @PostMapping("/add")
    public Result add(@Valid @RequestBody Talent talent) {
        return this.talentService.add(talent);
    }
}