package com.example.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hrms.entities.concretes.SchoolGrade;

import java.util.List;

public interface SchoolGradeDao extends JpaRepository<SchoolGrade,Integer> {
    List<SchoolGrade> findAll();
}
