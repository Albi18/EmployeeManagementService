package com.employeManagementService.Employemanagement.Controller;

import com.employeManagementService.Employemanagement.Entity.Employee;
import com.employeManagementService.Employemanagement.Response.ResponseClass;
import com.employeManagementService.Employemanagement.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

@RestController
@RequestMapping("/employeeService")
public class EmployeeManagementController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/getEmployeeList")
    public ResponseClass getAllEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        ResponseClass response = employeeService.getAllEmployees(page, size);
        return response;
    }

    @PostMapping("/addEmployee")
    public ResponseClass addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/{id}")
    public ResponseClass updateEmployee(@PathVariable Integer id, @RequestBody Employee employeeDetails) {
        return employeeService.updateEmployee(id, employeeDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseClass deleteEmployee(@PathVariable Integer id) {
        return employeeService.deleteEmployee(id);
    }
}
