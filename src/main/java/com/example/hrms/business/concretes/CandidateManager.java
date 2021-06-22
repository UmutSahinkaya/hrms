package com.example.hrms.business.concretes;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hrms.business.abstracts.CandidateService;
import com.example.hrms.business.abstracts.EmailService;
import com.example.hrms.business.abstracts.VerifyCodeService;
import com.example.hrms.business.checkHelper.concretes.CandidateCheckHelper;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.core.utilities.results.adapters.UserCheckService;
import com.example.hrms.dataAccess.abstracts.CandidateDao;
import com.example.hrms.dataAccess.abstracts.UserDao;
import com.example.hrms.entities.concretes.Candidate;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
class CandidateManager implements CandidateService {

    private CandidateDao candidateDao;
    private EmailService emailService;
    private UserCheckService userCheckService;
    private VerifyCodeService verifyCodeService;
    private UserDao userDao;


    @Autowired
    public CandidateManager(CandidateDao candidateDao, EmailService emailService, UserCheckService userCheckService, VerifyCodeService verifyCodeService, UserDao userDao) {

        this.candidateDao = candidateDao;
        this.emailService = emailService;
        this.userCheckService = userCheckService;
        this.verifyCodeService = verifyCodeService;
        this.userDao = userDao;


    }


    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<>(this.candidateDao.findAll(), "Veriler Getirildi - Candidate");
    }


    @Override
    public Result register(Candidate candidate) {

        boolean isChecked = this.userCheckService.isPersonReal(candidate.getIdentityNumber(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthYear());
        //boolean checkFields = CandidateCheckHelper.allFieldsAreReq(candidate);

        String errorMsg = "";
        boolean flag = false;
        if (!isChecked) {

            return new ErrorResult("Mernis Doğrulama Hatası Bilgilerinizi Doğru Girin !");

        }
        if (this.userDao.existsByEmail(candidate.getEmail())) {

            errorMsg = "Bu Mail Adresi ile İşleşen Zaten Bir Kayıt Var. | ";
            flag = true;

        }
        if (this.candidateDao.existsByIdentityNumber(candidate.getIdentityNumber())) {

            errorMsg += "Bu T.C Kimlik Numarası ile İşleşen Zaten Bir Kayıt Var. |";
            flag = true;
        }
        if (!candidate.getPassword().equals(candidate.getPasswordAgain())) {
            errorMsg += "Girdiğiniz Şifreler Birbirleri İle Uyuşmuyor.";
            flag = true;
        }
        if (flag) {
            return new ErrorResult(errorMsg, HttpStatus.SC_BAD_REQUEST);
        }
        this.candidateDao.save(candidate);
        this.verifyCodeService.createVerifyCode(candidate);
        return new SuccessResult(this.emailService.sendEmail(candidate).getMessage());

    }
}



