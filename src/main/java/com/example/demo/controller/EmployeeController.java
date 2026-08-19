package com.example.demo.controller;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.service.EmployeeService;

import jakarta.validation.Valid;

import java.util.List;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    
    @Autowired
    EmployeeService employeeService;


    @GetMapping("/getall")
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    public List<EmployeeDTO> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public EmployeeDTO createEmployee(@Valid @RequestBody EmployeeDTO employee) {
        return employeeService.createEmployees(employee);
    }

    @GetMapping("/getbyid/{empId}")
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    public EmployeeDTO getEmployeeById(@PathVariable int empId) {
        return employeeService.getEmployeeById(empId);
    }

    @PutMapping("/editbyid/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public EmployeeDTO updateEmployees(@PathVariable int id,@Valid @RequestBody EmployeeDTO employee) {
        return employeeService.updateEmployees(id, employee);
    }

    @DeleteMapping("/deletebyid/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }
}