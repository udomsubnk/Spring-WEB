package com.example.springboot.controller;

import com.example.springboot.domain.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    @RequestMapping("/employees")

    // @ResponseBody is field mapper
    @ResponseBody
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("John", "Doe"));
        employeeList.add(new Employee("Kao", "Jan"));
        return employeeList;
    }

}
