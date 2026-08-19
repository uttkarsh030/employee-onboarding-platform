package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.EmployeeDTO;

public interface EmployeeService {

    List<EmployeeDTO> getAllEmployee();
    EmployeeDTO createEmployees(EmployeeDTO employees);
    EmployeeDTO getEmployeeById(int id);
    EmployeeDTO updateEmployees(int id, EmployeeDTO employee);
    void deleteEmployee(int id);
}