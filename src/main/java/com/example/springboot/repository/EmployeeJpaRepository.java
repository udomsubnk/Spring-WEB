package com.example.springboot.repository;

import com.example.springboot.domain.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Employee employee) {
        // persist -> if there is 'id' in employee, it will update
        // persist -> if there isn't 'id' in employee, it will insert
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

    @Transactional
    public void delete(Employee employee) {
        entityManager.remove(employee);
    }

    public List<Employee> findByFirstName(String firstName) {
        Query query = entityManager.createQuery("from Employee t where t.firstName =: FIRST_NAME");
        query.setParameter("FIRST_NAME", firstName);
        return query.getResultList();
    }

    public List<Employee> findByNativeQuery() {
        Query query = entityManager.createNativeQuery("SELECT * FROM EMPLOYEE", Employee.class);
        return query.getResultList();
    }
}
