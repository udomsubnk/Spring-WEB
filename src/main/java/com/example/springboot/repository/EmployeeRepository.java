package com.example.springboot.repository;

import com.example.springboot.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByFirstName(String firstName);

    //  @Query(value = "SELECT * FROM EMPLOYEE where first_name = ?1", nativeQuery = true)
    @Query(value = "SELECT e from Employee e where e.firstName = ?1")
    List<Employee> findByFirstNameAndLastName(String firstName, String lastName);
}
