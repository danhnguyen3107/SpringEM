package com.code.project.projectv1.service;

import com.code.project.projectv1.entity.Employee;
import com.code.project.projectv1.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee findById(int user);
    void delete(int id);
    Page< Employee > findPaginated(int pageNo);
    Page<Employee> findByName(int pageNo, String text, String sortBy);
    Page< Employee > findBySort(int pageNo, String sortBy);
}
