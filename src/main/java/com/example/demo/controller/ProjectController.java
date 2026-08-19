package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProjectDTO;
import com.example.demo.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/getall")
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    List<ProjectDTO> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/getbyid/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    ProjectDTO getProjectById(@PathVariable int id) {
        return projectService.getProjectById(id);
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    ProjectDTO createProject(@RequestBody ProjectDTO projectDTO) {
        return projectService.createProject(projectDTO);
    }

    @PutMapping("/updatebyid/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    ProjectDTO updateProject(@PathVariable int id, @RequestBody ProjectDTO projectDTO) {
        return projectService.updateProject(id, projectDTO);
    }

    @DeleteMapping("/deletebyid/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    void deleteProject(@PathVariable int id) {
        projectService.deleteProject(id);
    }

    @PostMapping("/{projectId}/assignedto/{employeeId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    ProjectDTO assignEmployeeProject(@PathVariable int projectId, @PathVariable int employeeId) {
        return projectService.assignEmployeeProject(projectId, employeeId);
    }

    @DeleteMapping("/{projectId}/remove/{employeeId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    ProjectDTO removeEmployeeProject(@PathVariable int projectId, @PathVariable int employeeId) {
        return projectService.removeEmployeeProject(projectId, employeeId);
    }
}