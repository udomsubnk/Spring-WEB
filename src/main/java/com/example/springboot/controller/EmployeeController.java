package com.example.springboot.controller;

import com.example.springboot.domain.Employee;
import com.example.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // API
    @RequestMapping("/employees")
    // @ResponseBody is field mapper
    @ResponseBody
    public List<Employee> findAll() {
        return employeeService.listAllEmployees();
    }

    @RequestMapping("/employees/{id}")
    @ResponseBody
    public Employee getEmployee(@PathVariable Integer id) {
        return employeeService.findById(id);
    }

}
