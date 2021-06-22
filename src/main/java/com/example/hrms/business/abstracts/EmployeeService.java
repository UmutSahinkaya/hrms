package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.Employee;
import com.example.hrms.entities.concretes.Employer;


import java.util.List;

public interface EmployeeService {
    DataResult<List<Employee>> getAll();
    DataResult<Boolean> confirmEmployer(Employee staffUser, Employer confirmedEmployerUser);

}
