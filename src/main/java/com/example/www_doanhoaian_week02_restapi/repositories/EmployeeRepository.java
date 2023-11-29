package com.example.www_doanhoaian_week02_restapi.repositories;


import com.example.www_doanhoaian_week02_restapi.enums.EmployeeStatus;
import com.example.www_doanhoaian_week02_restapi.models.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class EmployeeRepository {
    private final EntityManager em;
    private final EntityTransaction transaction;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public EmployeeRepository() {
        em = ConnectDB.getInstance().getEntityManagerFactory().createEntityManager();
        transaction = em.getTransaction();
    }

    public void insertEmp(Employee employee) {
        try {
            transaction.begin();
            em.persist(employee);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            logger.error(ex.getMessage());
        }
    }

    public void setStatus(Employee employee, EmployeeStatus status) {
        employee.setEmployeeStatus(status);
    }

    public void update(Employee employee) {
        try {
            transaction.begin();
            em.merge(employee);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            logger.error(ex.getMessage());
        }
    }

    public Optional<Employee> findById(long id) {
        Employee rs = em.find(Employee.class, id);
        return rs == null ? Optional.empty() : Optional.of(rs);
    }

    public List<Employee> getAllEmp() {
        return em.createNamedQuery("Employee.findAll", Employee.class)
                .setParameter("status", EmployeeStatus.ACTIVE)
                .getResultList();
    }

}
