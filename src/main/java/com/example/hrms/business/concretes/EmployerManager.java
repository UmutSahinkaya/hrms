package com.example.hrms.business.concretes;


import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.hrms.business.abstracts.EmailService;
import com.example.hrms.business.abstracts.EmployerService;
import com.example.hrms.business.abstracts.VerifyCodeService;
import com.example.hrms.core.utilities.cloudinary.CloudinaryService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.EmployerDao;
import com.example.hrms.dataAccess.abstracts.UserDao;
import com.example.hrms.entities.concretes.CurriculumViate;
import com.example.hrms.entities.concretes.Employer;

import java.util.List;
import java.util.Map;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private EmailService emailService;
    private VerifyCodeService verifyCodeService;
    private UserDao userDao;
    private CloudinaryService cloudinaryService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, EmailService emailService, VerifyCodeService verifyCodeService, UserDao userDao, CloudinaryService cloudinaryService) {
        this.employerDao = employerDao;
        this.emailService = emailService;
        this.verifyCodeService = verifyCodeService;
        this.userDao = userDao;
        this.cloudinaryService = cloudinaryService;
    }


    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>(this.employerDao.findAll(), "Veriler Getirildi - Employer");
    }

    @Override
    public Result register(Employer employer) {

        String errorMsg = "";
        boolean flag = false;

        if (this.userDao.existsByEmail(employer.getEmail())){

            errorMsg = "Bu Mail Adresi ile İşleşen Zaten Bir Kayıt Var. | ";
            flag = true;

        }

        if (!employer.getPassword().equals(employer.getPasswordAgain())) {
            errorMsg += "Girdiğiniz Şifreler Birbirleri İle Uyuşmuyor.";
            flag = true;
        }
        if (flag){
            return new ErrorResult(errorMsg, HttpStatus.SC_BAD_REQUEST);
        }
        this.employerDao.save(employer);
        this.verifyCodeService.createVerifyCode(employer);
        return new SuccessResult(this.emailService.sendEmail(employer).getMessage());


        /*boolean checkFields = !EmployerCheckHelper.allFieldReq(employer);
        boolean isConfirm = !EmployeeCheckHelper.isConfirmed(employer);
        if (checkFields || isConfirm) {
            return new ErrorResult("Hata - Employer eklenemedi");
        }
        this.employerDao.save(employer);
        this.verifyCodeService.createVerifyCode(userDao.getOne(employer.getId()));
        this.emailService.sendEmail(employer);
        return new SuccessResult(this.emailService.sendEmail(employer).getMessage());*/
    }

    @Override
    public Result saveImage(MultipartFile file, int empId) {
        try {
            Map<String, String> uploader = (Map<String, String>) cloudinaryService.save(file).getData();
            String imageUrl= uploader.get("url");
            Employer employer = employerDao.getOne(empId);
            employer.setPhoto(imageUrl);
            employerDao.save(employer);
        }catch (Exception e){
            return new ErrorResult("Geçersiz Medya Türü !");
        }

        return new SuccessResult("Fotoğraf Ekleme Başarılı");
    }


}