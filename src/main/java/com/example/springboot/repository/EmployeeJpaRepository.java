package com.example.springboot.repository;

import com.example.springboot.domain.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    public List<Employee> findAll() {
        // query language -> JPQL
        // from Employee -> is Employee class name
        return entityManager.createQuery("from Employee").getResultList();
    }

    public Employee findById(Integer id) {
        return entityManager.find(Employee.class, id);
    }
}
