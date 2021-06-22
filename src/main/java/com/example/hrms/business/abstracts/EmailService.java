package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.User;

public interface EmailService {
    Result sendEmail(User user);
}