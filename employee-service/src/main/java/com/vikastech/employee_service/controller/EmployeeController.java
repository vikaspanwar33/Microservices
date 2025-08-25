package com.vikastech.employee_service.controller;

import com.vikastech.employee_service.model.Employee;
import com.vikastech.employee_service.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeRepository employeeRepository;

    private List<Employee> employees = new ArrayList<>();

    @PostMapping
    public Employee add(@RequestBody Employee employee) {
        LOGGER.info("Adding Employee: {}", employee);
        return employeeRepository.add((employee));
    }

    @GetMapping
    public List<Employee> findAll() {
        LOGGER.info("Finding All Employees");
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById( @PathVariable("id") Long id) {
        LOGGER.info("Finding Employee by ID: {}", id);
        return employeeRepository.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartmentId(@PathVariable("departmentId") Long departmentId) {
        LOGGER.info("Finding Employee: departmentId={}", departmentId);
        return employeeRepository.findByDepartmentId(departmentId);
    }
}
