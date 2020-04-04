package com.example.springboot.repository;

import com.example.springboot.domain.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class EmployeeJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Employee employee) {
        entityManager.persist(employee);
    }
}
