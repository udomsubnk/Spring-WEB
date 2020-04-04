package com.example.springboot.controller;

import com.example.springboot.domain.Employee;
import com.example.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
// @ResponseBody is field mapper
@RequestMapping("/employees")
@ResponseBody
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // API
    @GetMapping
    public List<Employee> findAll() {
        return employeeService.listAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        return employeeService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody Employee employee) {
        employeeService.save(employee);
    }
}
