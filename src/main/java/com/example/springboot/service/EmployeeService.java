package com.example.springboot.service;


import com.example.springboot.domain.Employee;
import com.example.springboot.repository.EmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    public List<Employee> listAllEmployees() {
        return employeeJpaRepository.findAll();
    }

    public Employee findById(Integer id) {
        return employeeJpaRepository.findById(id);
    }
}
