package com.example.demo.dto;

import java.time.LocalDateTime;
import java.util.List;

public class DepartmentDTO {
    private Integer id;
    private String departmentName;
    private String location;
    private int budget;
    private List<EmployeeDTO> employees;
    
    public DepartmentDTO() {
    }
    public DepartmentDTO(Integer id, String departmentName, String location, int budget) {
        this.id = id;
        this.departmentName = departmentName;
        this.location = location;
        this.budget = budget;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getBudget() {
        return budget;
    }
    public void setBudget(int budget) {
        this.budget = budget;
    }
    public List<EmployeeDTO> getEmployees() {
        return employees;
    }
    public void setEmployees(List<EmployeeDTO> employees) {
        this.employees = employees;
    }
}
