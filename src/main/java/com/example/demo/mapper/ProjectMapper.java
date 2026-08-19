package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.demo.dto.ProjectDTO;
import com.example.demo.entity.Project;

@Mapper(componentModel = "spring", uses = {EmployeeMapper.class})
public interface ProjectMapper {

    @Mappings({
        @Mapping(source  = "employees", target = "employees")
    })
    ProjectDTO toDTO(Project project);

    @Mappings({
        @Mapping(target = "employees", ignore = true)
    })
    Project toEntity(ProjectDTO projectDTO);

}

