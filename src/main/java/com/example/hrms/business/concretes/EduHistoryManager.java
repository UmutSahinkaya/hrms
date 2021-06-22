package com.example.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hrms.business.abstracts.EduHistoryService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.EduHistoryDao;
import com.example.hrms.entities.concretes.EduHistory;

import java.time.LocalDate;
import java.util.List;

@Service
public class EduHistoryManager implements EduHistoryService {

    private EduHistoryDao eduHistoryDao;

    @Autowired
    public EduHistoryManager(EduHistoryDao eduHistoryDao){
        this.eduHistoryDao = eduHistoryDao;
    }


    @Override
    public Result add(EduHistory eduHistory) {
        eduHistory.setCreatedDate(LocalDate.now());
        this.eduHistoryDao.save(eduHistory);
        return new SuccessResult("Başarı İle Eklendi");
    }

    @Override
    public DataResult<List<EduHistory>> getAll() {
        return new SuccessDataResult<List<EduHistory>>(this.eduHistoryDao.findAll(),"Başarı ile Getirildi - EduHistory");
    }
}