package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employees;

@Mapper(componentModel = "spring", uses = {ProjectMapper.class})
public interface EmployeeMapper {
    @Mappings({
        @Mapping(source = "department.id", target = "departmentId"),
        @Mapping(source = "department.departmentName", target = "departmentName"),
        @Mapping(source = "projects", target = "projects")
    })
    EmployeeDTO mapEmployeeToEmployeeDTO(Employees employees);
   
   @Mapping(target = "department", ignore = true)
   @Mapping(target = "projects", ignore = true)
    Employees mapEmployeeDTOToEmployees(EmployeeDTO employeeDTO);
}
