package com.example.demo.service.impl;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employees;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employees> employees =  employeeRepository.findAll();
        
        List<EmployeeDTO> dtos = new ArrayList<>();
        for(Employees emp : employees) {
            dtos.add(employeeMapper.mapEmployeeToEmployeeDTO(emp));
        }
        return dtos;
    }

    @Override
    public EmployeeDTO createEmployees(EmployeeDTO employeeDTO) {
        Employees employee = employeeMapper.mapEmployeeDTOToEmployees(employeeDTO);

        if (employeeDTO.getDepartmentId() != null) {
            Department department = departmentRepository.findById(employeeDTO.getDepartmentId())
                .orElse(null);
            employee.setDepartment(department);
        }

        Employees savedEmployee = employeeRepository.save(employee);
        return employeeMapper.mapEmployeeToEmployeeDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(int id) {
        Employees employees = employeeRepository.findById(id).orElse(null);

        return employeeMapper.mapEmployeeToEmployeeDTO(employees);
        
    }
    
    @Override
    public EmployeeDTO updateEmployees(int id, EmployeeDTO employeeDTO) {
        Employees existingEmployee = employeeRepository.findById(id).orElse(null);
        if(existingEmployee != null) {
            existingEmployee.setName(employeeDTO.getName());
            existingEmployee.setDesignation(employeeDTO.getDesignation());
            existingEmployee.setSalary(employeeDTO.getSalary());
            existingEmployee.setEmail(employeeDTO.getEmail());

            if (employeeDTO.getDepartmentId() != null) {
                Department department = departmentRepository.findById(employeeDTO.getDepartmentId())
                    .orElse(null);
                existingEmployee.setDepartment(department);
            }


            Employees updateEmployee = employeeRepository.save(existingEmployee);
            return employeeMapper.mapEmployeeToEmployeeDTO(updateEmployee);
        }
        return null;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}