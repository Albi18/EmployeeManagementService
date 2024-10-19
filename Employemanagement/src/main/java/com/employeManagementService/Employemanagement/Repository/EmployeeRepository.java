package com.employeManagementService.Employemanagement.Repository;

import com.employeManagementService.Employemanagement.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
