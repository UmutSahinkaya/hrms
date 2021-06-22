package com.example.hrms.business.checkHelper.concretes;


import org.springframework.stereotype.Service;
import com.example.hrms.entities.concretes.Candidate;


public class CandidateCheckHelper {

    public static boolean allFieldsAreReq(Candidate candidate){
        if (candidate.getEmail().strip().isEmpty()
                || candidate.getPassword().strip().isEmpty()
                || candidate.getFirstName().strip().isEmpty()
                || candidate.getLastName().strip().isEmpty()
                || candidate.getIdentityNumber().strip().isEmpty()
        )
        {
            return false;
        }
        return true;
    }

}