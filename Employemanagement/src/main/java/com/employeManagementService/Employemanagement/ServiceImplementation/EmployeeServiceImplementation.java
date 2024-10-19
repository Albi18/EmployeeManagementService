package com.employeManagementService.Employemanagement.ServiceImplementation;

import com.employeManagementService.Employemanagement.Entity.Employee;
import com.employeManagementService.Employemanagement.Repository.EmployeeRepository;
import com.employeManagementService.Employemanagement.Response.ResponseClass;
import com.employeManagementService.Employemanagement.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public ResponseClass addEmployee(Employee employee) {
        ResponseClass responseClass = new ResponseClass();
        try {
            Employee savedEmployee = employeeRepository.save(employee);
            responseClass.setMessage("Employee added successfully!");
        } catch (Exception e) {
            responseClass.setMessage("Error adding employee: " + e.getMessage());
        }
        return responseClass;
    }

    @Override
    public ResponseClass getAllEmployees(int page, int size) {
        Page<Employee> employeePage = employeeRepository.findAll(PageRequest.of(page, size));
        ResponseClass response = new ResponseClass();
        response.setMessage("Employees retrieved successfully");
        response.setData(employeePage.getContent());
        return response;
    }

    @Override
    public ResponseClass updateEmployee(Integer id,Employee employeeDetails) {
        ResponseClass responseClass = new ResponseClass();
        try {
            Employee employee = employeeRepository.findById(id).orElseThrow(null);
            employee.setName(employeeDetails.getName());
            employee.setAge(employeeDetails.getAge());
            employee.setPosition(employeeDetails.getPosition());
            employee.setSalary(employeeDetails.getSalary());
            employeeRepository.save(employee);
            responseClass.setMessage("Employee updated successfully!");
        }catch (Exception e) {
            responseClass.setMessage("Error updating employee: " + e.getMessage());
        }
        return responseClass;
        }


    @Override
    public ResponseClass deleteEmployee(Integer id) {
        ResponseClass responseClass = new ResponseClass();
        try {
            Employee employee = employeeRepository.findById(id).orElse(null);
            employeeRepository.delete(employee);
            responseClass.setMessage("Employee deleted successfully!");
        } catch (Exception e) {
            responseClass.setMessage("Error deleting employee: " + e.getMessage());
        }
        return responseClass;
    }
}
