package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Talent;

import java.util.List;

public interface TalentService {
    Result add(Talent talent);

    DataResult<List<Talent>> getAll();
}