package com.example.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hrms.entities.concretes.JobTitle;

import java.util.List;

public interface JobTitleDao extends JpaRepository<JobTitle,Integer> {

}
