package com.example.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hrms.entities.concretes.EduHistory;

public interface EduHistoryDao extends JpaRepository<EduHistory,Integer> {
}
