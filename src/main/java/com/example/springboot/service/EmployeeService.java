package com.example.springboot.service;


import com.example.springboot.domain.Employee;
import com.example.springboot.repository.EmployeeJpaRepository;
import com.example.springboot.repository.EmployeeRepository;
import com.example.springboot.response.EmployeeReportResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
   private EmployeeJpaRepository employeeJpaRepository;

    @Autowired
    EmployeeRepository employeeRepository;


    public List<Employee> listAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Data not found."));
    }

    public void save(Employee employee) {
        employeeJpaRepository.save(employee);
    }

    public void update(Integer id, Employee employee) {
        Employee employeeEntity = this.findById(id);
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());
        employeeJpaRepository.save(employeeEntity);
    }

    public void delete(Integer id) {
        Employee employeeEntity = this.findById(id);
        employeeJpaRepository.delete(employeeEntity);
    }

    public List<Employee> findByFirstName(String firstName) {
        return employeeJpaRepository.findByFirstName(firstName);
    }

    public List<EmployeeReportResponse> findByNativeQuery() {
        return employeeJpaRepository.findByNativeQuery();
    }
}
