package com.example.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hrms.business.abstracts.EmployeeService;

import com.example.hrms.business.checkHelper.concretes.EmployeeCheckHelper;


import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.dataAccess.abstracts.EmployeeDao;
import com.example.hrms.entities.concretes.Employee;
import com.example.hrms.entities.concretes.Employer;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }


    @Override
    public DataResult<List<Employee>> getAll() {

        return new SuccessDataResult<>(this.employeeDao.findAll(),"Veriler Getirildi - Employee");
    }

    @Override
    public DataResult<Boolean> confirmEmployer(Employee staffUser, Employer confirmedEmployerUser) {
        return new SuccessDataResult<>(EmployeeCheckHelper.isConfirmed(confirmedEmployerUser));
    }


}
