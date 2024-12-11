package com.hr.service.impl;

import com.hr.entity.Employee;
import com.hr.repo.EmployeeRepo;
import com.hr.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private final EmployeeRepo employeeRepo;
    @Override
    public Employee findById(Long id) {
        return employeeRepo.findById(id).orElse(null);
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepo.getById(id);
    }

    @Override
    public Employee findByFirstNameAndLastNameOrderById(String firstName, String lastName) {
        return employeeRepo.findByFirstNameAndLastNameOrderById(firstName, lastName);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee insert(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
//        Employee emp = employeeRepo.getById(employee.getId());
//        emp.setFirstName(employee.getFirstName());
//        emp.setLastName(employee.getLastName());
//        emp.setSalary(employee.getSalary());
//        emp.setHireDate(employee.getHireDate());

        return employeeRepo.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepo.deleteById(id);
    }
}
