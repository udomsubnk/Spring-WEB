package com.example.springboot.controller;

import com.example.springboot.domain.Employee;
import com.example.springboot.response.EmployeeReportResponse;
import com.example.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.listAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployees(@PathVariable Integer id) {
        return employeeService.findById(id);
    }

    @GetMapping("/firstName/{firstName}")
    public List<Employee> getEmployeesByFirstName(@PathVariable String firstName) {
        return employeeService.findByFirstName(firstName);
    }

    @GetMapping("/nativeQuery")
    public List<EmployeeReportResponse> getEmployees() {
        return employeeService.findByNativeQuery();
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        employeeService.save(employee);
        return employee;
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Integer id, @RequestBody Employee employee) {
        employeeService.update(id, employee);
        return employee;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        employeeService.delete(id);
    }
}
