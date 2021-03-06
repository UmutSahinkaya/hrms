package com.example.hrms.business.concretes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.hrms.business.abstracts.JobAdvertisementService;
import com.example.hrms.core.utilities.cloudinary.CloudinaryService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.example.hrms.entities.concretes.CurriculumViate;
import com.example.hrms.entities.concretes.JobAdvertisement;
import com.example.hrms.entities.dtos.JobAdvertisementDto;

import java.util.List;
import java.util.Map;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;
    private CloudinaryService cloudinaryService;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, CloudinaryService cloudinaryService){
        this.cloudinaryService = cloudinaryService;
        this.jobAdvertisementDao = jobAdvertisementDao;
    }





    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>
                (this.jobAdvertisementDao.findAll(), "Veriler Getirildi - Job Advertisement");

    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllStatusTrue() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByStatusTrue());
    }

    @Override
    public DataResult<JobAdvertisement> getByJobAdvertisementId(int jobAdvertisementId) {
        return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.findAllByIdAndStatusTrue(jobAdvertisementId),"Id ye Göre Başarıyla Getirildi.");
    }

    @Override
    public DataResult<List<JobAdvertisement>> findAllByEmployer_IdAndStatusTrue(int employerId) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByEmployer_IdAndStatusTrue(employerId));
    }

    @Override
    public Result saveImage(MultipartFile file, int jobAdvertisementId) {
        try {
            Map<String, String> uploader = (Map<String, String>) cloudinaryService.save(file).getData();
            String imageUrl= uploader.get("url");
            JobAdvertisement jobAdvertisement = jobAdvertisementDao.getOne(jobAdvertisementId);
            jobAdvertisement.setPhoto(imageUrl);
            jobAdvertisementDao.save(jobAdvertisement);
        }catch (Exception e){
            return new ErrorResult("Geçersiz Medya Türü !");
        }

        return new SuccessResult("Fotoğraf Ekleme Başarılı");
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        try {
            this.jobAdvertisementDao.save(jobAdvertisement);
            return new SuccessResult("İş İlanı Başarı ile Kayıt Edildi");
        }catch (Exception e){
            return new ErrorResult("Hata ile Karşılaşıldı. İş ilanı Eklenemedi.");
        }
        //return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.save(jobAdvertisement));
    }

    @Override
    public Result findById(int jobAdvertisementId,boolean status) {
        try{
            JobAdvertisement jobAdvertisement;
            jobAdvertisement = this.jobAdvertisementDao.findById(jobAdvertisementId).get();

            jobAdvertisement.setStatus(status);

            this.jobAdvertisementDao.save(jobAdvertisement);

            return new SuccessResult("İşlem Başarılı");



        }catch (Exception e){
            return new ErrorResult("İşlem Başarısız");
        }
    }

    @Override
    public DataResult<List<JobAdvertisement>> findAllByStatusTrueSortedAsc() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByStatusTrueOrderByPublishDateAsc(),"Verilerden Aktif Olanlar Tarihe Göre Listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisement>>  findAllByStatusTrueOrderByPublishDateDesc() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByStatusTrueOrderByPublishDateDesc(),"Verilerden Aktif Olanlar Tarihe Göre Listelendi");

    }

    @Override
    public DataResult<List<JobAdvertisementDto>> getJobAdvertisementWithEmpDetails() {
        return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getJobAdvertisementWithEmpDetails());
    }

    @Override
    public DataResult<List<JobAdvertisementDto>> getJobAdvertisementWithEmpDetailsSıralamaAsc() {
        return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getJobAdvertisementWithEmpDetailsSıralamaAsc());
    }

    @Override
    public DataResult<List<JobAdvertisementDto>> getJobAdvertisementWithEmpDetailsByEmpId(int employerId) {
        return  new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getJobAdvertisementWithEmpDetailsByEmpId(employerId));
    }


}