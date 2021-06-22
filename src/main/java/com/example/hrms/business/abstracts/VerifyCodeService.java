package com.example.hrms.business.abstracts;


import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.User;

public interface VerifyCodeService {
    String createVerifyCode(User user);
    Result verifyUser(String code);

}