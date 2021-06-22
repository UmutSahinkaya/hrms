package com.example.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hrms.business.abstracts.LanguageService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.LanguageDao;
import com.example.hrms.entities.concretes.Language;

import java.time.LocalDate;
import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    private LanguageDao languageDao;

    @Autowired
    public LanguageManager(LanguageDao languageDao){
        this.languageDao=languageDao;
    }


    @Override
    public Result add(Language language) {
        language.setCreatedDate(LocalDate.now());
        this.languageDao.save(language);
        return new SuccessResult("Başarı İle Eklendi");
    }

    @Override
    public DataResult<List<Language>> getAll() {
        return new SuccessDataResult<List<Language>>(this.languageDao.findAll(),"Başarı İle Listelendi - Languages");
    }
}