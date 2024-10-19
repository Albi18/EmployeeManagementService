package com.employeManagementService.Employemanagement.Service;

import com.employeManagementService.Employemanagement.Entity.Employee;
import com.employeManagementService.Employemanagement.Response.ResponseClass;

import javax.persistence.criteria.CriteriaBuilder;

public interface EmployeeService {


    ResponseClass addEmployee(Employee employee);

    ResponseClass getAllEmployees(int page, int size);

    ResponseClass updateEmployee(Integer id,Employee employeeDetails);

    ResponseClass deleteEmployee(Integer id);
}
