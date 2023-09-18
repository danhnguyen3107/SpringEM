package com.code.project.projectv1.repository;

import com.code.project.projectv1.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface EmployeeRep extends JpaRepository<Employee, Integer> {
//    void addEmployee(Employee employee);
//    List<Employee> getAllEmployee();
//    Employee findById(int id);
    void deleteById(int id);
    Page<Employee> findByFirstNameLike(Pageable pageable, String text);


}
