package com.example.demo.dto;



import java.time.LocalDateTime;
import java.util.List;


import com.example.demo.entity.Project;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


public class EmployeeDTO {

    private Integer id;

    @NotBlank(message = "name cannot be kept BLANK")
    @Size(min = 2, max = 25, message = "Name must be b/w 2 to 50 chacters")
    private String name;

    private Integer departmentId;

    @Email
    private String email;
    private String designation;
    private Double salary;
    private String departmentName;

    private List<ProjectDTO> projects;


    private LocalDateTime createDate;

    private LocalDateTime lastModifiedDate;

    public EmployeeDTO() {}

    public EmployeeDTO(int id, String name, Integer departmentId, String email, Double salary, String designation) {
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
        this.email = email;
        this.designation = designation;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }


    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

        public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }

    public List<ProjectDTO> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectDTO> projects) {
        this.projects = projects;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    

}