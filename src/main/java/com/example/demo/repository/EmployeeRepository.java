package com.example.demo.repository;
//import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employees, Integer> {

}