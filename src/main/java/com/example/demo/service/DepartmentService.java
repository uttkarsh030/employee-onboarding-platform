package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.DepartmentDTO;

public interface DepartmentService {

    List<DepartmentDTO> getallDepartments();
    DepartmentDTO getDepartmentById(int id);
    DepartmentDTO createDepartment(DepartmentDTO departmentDTO);
    DepartmentDTO updateDepartment(int id, DepartmentDTO departmentDTO);
    void deleteDepartment(int id);
}
