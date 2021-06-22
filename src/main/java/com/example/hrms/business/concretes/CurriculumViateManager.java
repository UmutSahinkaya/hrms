package com.example.hrms.business.concretes;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.hrms.business.abstracts.CurriculumViateService;
import com.example.hrms.core.utilities.cloudinary.CloudinaryManager;
import com.example.hrms.core.utilities.cloudinary.CloudinaryService;
import com.example.hrms.core.utilities.helpers.CurriculumVitaeHelper;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.*;
import com.example.hrms.entities.concretes.CurriculumViate;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class CurriculumViateManager implements CurriculumViateService {

    private CurriculumViateDao curriculumViateDao;
    private CloudinaryService cloudinaryService;

    /*private LanguageDao languageDao;
    private TalentDao talentDao;
    private EduHistoryDao eduHistoryDao;
    private JobExperienceDao jobExperienceDao;*/



    @Autowired
    public CurriculumViateManager(CurriculumViateDao curriculumViateDao,CloudinaryService cloudinaryService) {
        this.curriculumViateDao = curriculumViateDao;
        this.cloudinaryService = cloudinaryService;
    }


    @Override
    public DataResult<List<CurriculumViate>> getAll() {

        return new SuccessDataResult<List<CurriculumViate>>
                (this.curriculumViateDao.findAll(),"Veriler Getirildi - CV");
    }

    @Override
    public Result add(CurriculumViate curriculumViate) {

        curriculumViate.setCreatedDate(LocalDate.now());
        this.curriculumViateDao.save(curriculumViate);
        return new SuccessResult("Başarılııııı");

        /*CurriculumViate resea = curriculumVitaeDao.save(curriculumViate);
        CurriculumVitaeHelper helper = new CurriculumVitaeHelper(eduHistoryDao,talentDao,languageDao,jobExperienceDao);
        helper.setAllCurriculumVitaeId();
                (resea.getEducation(), resea.getLanguages(),
                        resea.getTechnologies(), resea.getJobExperiences(), resea);
        return new SuccessResult("Kayıt Başarılı");*/
    }



    @Override
    public Result saveImage(MultipartFile file, int cvId) {
        try {
            Map<String, String> uploader = (Map<String, String>) cloudinaryService.save(file).getData();
            String imageUrl= uploader.get("url");
            CurriculumViate cv = curriculumViateDao.getOne(cvId);
            cv.setPhoto(imageUrl);
            curriculumViateDao.save(cv);
        }catch (Exception e){
            return new ErrorResult("Geçersiz Medya Türü !");
        }

        return new SuccessResult("Fotoğraf Ekleme Başarılı");
    }

    @Override
    public DataResult<List<CurriculumViate>> getByCandidateId(int id) {
        return new SuccessDataResult<List<CurriculumViate>>
                (this.curriculumViateDao.getByCandidate_Id(id));
    }
}
