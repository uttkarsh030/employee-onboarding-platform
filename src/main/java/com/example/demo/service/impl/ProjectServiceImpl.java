package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProjectDTO;
import com.example.demo.entity.Employees;
import com.example.demo.entity.Project;
import com.example.demo.mapper.ProjectMapper;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<ProjectDTO> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        List<ProjectDTO> dtos = new ArrayList<>();

        for(Project project : projects) {
            ProjectDTO projectDTO = projectMapper.toDTO(project);
            dtos.add(projectDTO);
        }
        return dtos;
    }

    @Override
    public ProjectDTO getProjectById(int id) {
        Project project = projectRepository.findById(id).orElse(null);
        return projectMapper.toDTO(project);
    }

    @Override
    public ProjectDTO createProject(ProjectDTO projectDTO) {
        Project project = projectMapper.toEntity(projectDTO);
        Project saved = projectRepository.save(project);
        return projectMapper.toDTO(saved);
    }

    @Override
    public ProjectDTO updateProject(int id, ProjectDTO projectDTO) {
        Project existing = projectRepository.findById(id).orElse(null);
        if(existing != null) {
            if (projectDTO.getProjectName() != null) 
                existing.setProjectName(projectDTO.getProjectName());
            if (projectDTO.getDescription() != null) 
                existing.setDescription(projectDTO.getDescription());
            if (projectDTO.getStartDate() != null) 
                existing.setStartDate(projectDTO.getStartDate());
            if (projectDTO.getEndDate() != null) 
                existing.setEndDate(projectDTO.getEndDate());
            if (projectDTO.getStatus() != null) 
                existing.setStatus(projectDTO.getStatus());

            Project updated = projectRepository.save(existing);
            return projectMapper.toDTO(updated);
        }
        return null;
    }

    @Override
    public void deleteProject(int id) {
        projectRepository.deleteById(id);
    }

    @Override
    public ProjectDTO assignEmployeeProject(int projectId, int employeeId) {
        Project project = projectRepository.findById(projectId).orElse(null);
        Employees employee = employeeRepository.findById(employeeId).orElse(null);

        if(project != null && employee != null) {
            if(project.getEmployees() == null) {
                project.setEmployees(new HashSet<>());
            }
            project.getEmployees().add(employee);

            if(employee.getProjects() == null) {
                employee.setProjects(new HashSet<>());
            }
            employee.getProjects().add(project);

            Project saved = projectRepository.save(project);
            employeeRepository.save(employee);
            return projectMapper.toDTO(saved);
        }
        return null;
    }

    @Override
    public ProjectDTO removeEmployeeProject(int projectId, int employeeId) {
        Project project = projectRepository.findById(projectId).orElse(null);
        Employees employee = employeeRepository.findById(employeeId).orElse(null);

        if(project != null && employee != null && project.getEmployees() != null) {

            project.getEmployees().remove(employee);
            if(employee.getProjects() != null) {
                employee.getProjects().remove(project);
            }

            Project saved = projectRepository.save(project);
            employeeRepository.save(employee);
            return projectMapper.toDTO(saved);
        }
        return null;
    }

}
