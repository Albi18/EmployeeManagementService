package com.employeManagementService.Employemanagement.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseClass {
    private String message;
    private Object data;
}
