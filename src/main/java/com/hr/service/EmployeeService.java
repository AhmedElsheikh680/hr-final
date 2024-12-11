package com.hr.service;

import com.hr.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee findById(Long id);
    Employee getById(Long id);

    Employee findByFirstNameAndLastNameOrderById(String firstName, String lastName);

    List<Employee> findAll();

    Employee insert(Employee employee);

    Employee update(Employee employee);

    void deleteById(Long id);
}
