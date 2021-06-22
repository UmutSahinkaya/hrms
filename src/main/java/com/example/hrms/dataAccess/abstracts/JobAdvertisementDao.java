package com.example.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.hrms.entities.concretes.Employer;
import com.example.hrms.entities.concretes.JobAdvertisement;
import com.example.hrms.entities.dtos.JobAdvertisementDto;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

    JobAdvertisement findAllByIdAndStatusTrue(int id);

    List<JobAdvertisement> findAllByStatusTrue();

    List<JobAdvertisement> findAllByEmployer_IdAndStatusTrue(int employerId);

    List<JobAdvertisement> findAllByStatusTrueOrderByPublishDateAsc();

    List<JobAdvertisement> findAllByStatusTrueOrderByPublishDateDesc();




    @Query("Select new com.example.hrms.entities.dtos.JobAdvertisementDto"
            + "( j.jobTitle , p.jobOfNumberPosition, p.publishDate, p.endOfJobDate, e.companyName) "
            + "From JobTitle j Inner Join j.jobAdvertisements p Inner Join p.employer e Where p.status = 'true'")
    List<JobAdvertisementDto> getJobAdvertisementWithEmpDetails();


    // Hibernate model mapper ! important

    @Query("Select new com.example.hrms.entities.dtos.JobAdvertisementDto"
            + "( j.jobTitle , p.jobOfNumberPosition, p.publishDate, p.endOfJobDate, e.companyName) "
            + "From JobTitle j Inner Join j.jobAdvertisements p Inner Join p.employer e Where p.status = 'true' Order By p.publishDate ASC")
    List<JobAdvertisementDto> getJobAdvertisementWithEmpDetailsSıralamaAsc();

    @Query("SELECT new com.example.hrms.entities.dtos.JobAdvertisementDto" +
            "(jb.jobTitle , ja.jobOfNumberPosition, ja.publishDate, ja.endOfJobDate, e.companyName)" +
            "FROM JobAdvertisement ja " +
            "INNER JOIN ja.jobTitle jb " +
            "INNER JOIN ja.employer e " +
            "WHERE e.id=:employerId And ja.status = 'true'")
    List<JobAdvertisementDto> getJobAdvertisementWithEmpDetailsByEmpId(int employerId);

}