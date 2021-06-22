package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.EduHistory;

import java.util.List;

public interface EduHistoryService {
    Result add(EduHistory eduHistory);
    DataResult<List<EduHistory>> getAll();
}
