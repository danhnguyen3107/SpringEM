package com.code.project.projectv1.repository;

import com.code.project.projectv1.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

//@Repository
public class EmployeeRepImpl{
//    @Autowired
//    private EntityManager entityManager;
//    @Override
//    @Transactional
//    public void addEmployee(Employee employee) {
//        entityManager.merge(employee);
//    }
//
//    @Override
//    public List<Employee> getAllEmployee() {
//        return entityManager.createQuery("FROM Employee", Employee.class).getResultList();
//    }
//
//    @Override
//    public Employee findById(int id) {
//
//        return entityManager.find(Employee.class, id);
//
//    }
//
//    @Override
//    @Transactional
//    public void delete(int id) {
//        entityManager.remove(findById(id));
//    }
//
//    @Override
//    public List<Employee> findByName(String text) {
//        return entityManager.createQuery("SELECT t FROM Employee t WHERE t.firstName LIKE :text OR t.lastName LIKE :text", Employee.class)
//                .setParameter("text", "%" + text + "%").getResultList();
//    }
}
