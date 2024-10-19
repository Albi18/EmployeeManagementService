package com.employeManagementService.Employemanagement.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    private Integer age;
    @NotBlank(message = "Position is mandatory")
    private String position;
    @NotNull(message = "Salary is mandatory")
    @Min(value = 0, message = "Salary should be a positive value")
    private Double salary;
}
