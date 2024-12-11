package com.hr.controller;

import com.hr.dto.EmployeeDTO;
import com.hr.entity.Employee;
import com.hr.mapper.EmployeeMapper;
import com.hr.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable Long id) {
        Employee employee = employeeService.findById(id);
        EmployeeDTO dto = employeeMapper.map(employee);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/filter")
    public ResponseEntity<EmployeeDTO> filter(@RequestParam String firstName, String lastName) {
       Employee entity =  employeeService.findByFirstNameAndLastNameOrderById(firstName, lastName);
       EmployeeDTO dto = employeeMapper.map(entity);
       return ResponseEntity.ok(dto);
    }

    @GetMapping("")
    public ResponseEntity<List<EmployeeDTO>> findAll() {
            List<Employee> entities = employeeService.findAll();
           List<EmployeeDTO> dtos =  employeeMapper.map(entities);
           return ResponseEntity.ok(dtos);
    }
    @PostMapping("")
    public ResponseEntity<EmployeeDTO> insert(@RequestBody EmployeeDTO employeeDTO) {
       Employee entity =  employeeMapper.unMap(employeeDTO);
        Employee emp = employeeService.insert(entity);
        EmployeeDTO dto = employeeMapper.map(emp);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("")
    public ResponseEntity<EmployeeDTO> update(@RequestBody EmployeeDTO employeeDTO) {
        Employee currEmployee = employeeService.getById(employeeDTO.getId());
        Employee emp = employeeMapper.unMap(employeeDTO, currEmployee);
        Employee entity = employeeService.update(emp);
        EmployeeDTO dto = employeeMapper.map(entity);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        employeeService.deleteById(id);
        return ResponseEntity.ok(null);
    }


















}
