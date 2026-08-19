package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.entity.Department;

@Mapper(componentModel = "spring", uses = {EmployeeMapper.class})
public interface DepartmentMapper {
     
    //@Mapping(target = "employees", ignore = true)
    DepartmentDTO toDTO(Department department);

    @Mapping(target = "employees", ignore = true)
    Department toEntity(DepartmentDTO departmentDTO);
}
