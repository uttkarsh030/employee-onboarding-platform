package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.entity.Department;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<DepartmentDTO> getallDepartments() {
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentDTO> dtos = new ArrayList<>();
        for(Department dept : departments) {
            dtos.add(departmentMapper.toDTO(dept));
        }
        return dtos;
    }

    @Override
    public DepartmentDTO getDepartmentById(int id) {
        Department department = departmentRepository.findById(id).orElse(null);
        return departmentMapper.toDTO(department);
    }

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        Department department = departmentMapper.toEntity(departmentDTO);
        Department saved = departmentRepository.save(department);
        return departmentMapper.toDTO(saved);
    }

    @Override
    public DepartmentDTO updateDepartment(int id, DepartmentDTO departmentDTO) {
        Department existing = departmentRepository.findById(id).orElse(null);
        if(existing != null) {
            existing.setDepartmentName(departmentDTO.getDepartmentName());
            existing.setLocation(departmentDTO.getLocation());
            existing.setBudget(departmentDTO.getBudget());
            Department updated = departmentRepository.save(existing);
            return departmentMapper.toDTO(updated);
        }
        return null;
    }

    @Override
    public void deleteDepartment(int id) {
        departmentRepository.deleteById(id);
    }

}
