package com.example.springboot.service;


import com.example.springboot.domain.Employee;
import com.example.springboot.repository.EmployeeJpaRepository;
import com.example.springboot.response.EmployeeReportResponse;
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

    public void save(Employee employee) {
        employeeJpaRepository.save(employee);
    }

    public void update(Integer id, Employee employee) {
        Employee employeeEntity = findById(id);

        if (employeeEntity == null) {
            throw new RuntimeException("Not found data.");
        }

        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());
        employeeJpaRepository.save(employeeEntity);
    }

    public void delete(Integer id) {
        Employee employeeEntity = findById(id);

        if (employeeEntity == null) {
            throw new RuntimeException("Not found data.");
        }

        employeeJpaRepository.delete(employeeEntity);
    }

    public List<Employee> findByFirstName(String firstName) {
        return employeeJpaRepository.findByFirstName(firstName);
    }

    public List<EmployeeReportResponse> findByNativeQuery() {
        return employeeJpaRepository.findByNativeQuery();
    }
}
