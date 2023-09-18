package com.code.project.projectv1.service;

import com.code.project.projectv1.entity.Employee;

import com.code.project.projectv1.repository.EmployeeRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRep employeeRep;
    @Override
    public void addEmployee(Employee employee) {
        employeeRep.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRep.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeRep.findById(id).get();
    }

    @Override
    public void delete(int id) {
        employeeRep.deleteById(id);
    }

    @Override
    public Page<Employee> findPaginated(int pageNo) {
        Pageable pageable = PageRequest.of(pageNo-1, 2);
        return employeeRep.findAll(pageable);
    }

    @Override
    public Page<Employee> findByName(int pageNo, String text, String sortBy) {

        Pageable pageable = null;
        if (sortBy != null && !sortBy.isEmpty()){
            pageable = PageRequest.of(pageNo-1, 2, Sort.by(sortBy));
        }else  pageable = PageRequest.of(pageNo-1, 2);

        return employeeRep.findByFirstNameLike(pageable, text);
    }

    @Override
    public Page<Employee> findBySort(int pageNo, String sortBy) {
        Sort sort = Sort.by(sortBy + "");
        Pageable pageable = PageRequest.of(pageNo-1, 2, sort);
        return employeeRep.findAll(pageable);
    }
}
