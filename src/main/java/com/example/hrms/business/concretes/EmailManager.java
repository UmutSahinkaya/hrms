package com.example.hrms.business.concretes;

import org.springframework.stereotype.Service;
import com.example.hrms.business.abstracts.EmailService;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.entities.concretes.User;

@Service
public class EmailManager implements EmailService {
    @Override
    public Result sendEmail(User user) {
        return new SuccessResult("Aktivasyon Kodu Başarı ile Gönderildi"+" "+ user.getEmail());
    }
}