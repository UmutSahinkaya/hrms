package com.example.hrms.business.concretes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hrms.business.abstracts.TalentService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.TalentDao;
import com.example.hrms.entities.concretes.Talent;

import java.time.LocalDate;
import java.util.List;

@Service
public class TalentManager implements TalentService {

    private TalentDao talentDao;

    @Autowired
    public TalentManager(TalentDao talentDao){
        this.talentDao = talentDao;
    }


    @Override
    public Result add(Talent talent) {
        talent.setCreatedDate(LocalDate.now());
        talentDao.save(talent);
        return new SuccessResult("Başarı ile eklendi");
    }

    @Override
    public DataResult<List<Talent>> getAll() {
        return new SuccessDataResult<List<Talent>>(this.talentDao.findAll(),"Başarı İle Getirildi - Talents");
    }

}
