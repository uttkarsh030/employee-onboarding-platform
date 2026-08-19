package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ProjectDTO;

public interface ProjectService {
    List<ProjectDTO> getAllProjects();
    ProjectDTO getProjectById(int id);
    ProjectDTO createProject(ProjectDTO projectDTO);
    ProjectDTO updateProject(int id, ProjectDTO projectDTO);
    void deleteProject(int id);
    ProjectDTO assignEmployeeProject(int projectId, int employeeId);
    ProjectDTO removeEmployeeProject(int projectId, int employeeId);
}
