package com.vikastech.department_service.controller;

import com.vikastech.department_service.client.EmployeeClient;
import com.vikastech.department_service.model.Department;
import com.vikastech.department_service.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping
    public Department add(@RequestBody Department department) {
        LOGGER.info("Adding Department: {}", department);
        return repository.addDepartment((department));
    }

    @GetMapping
    public List<Department> findAll() {
        LOGGER.info("Finding All Departments");
        return repository.findAll();
    }

    public Department findById( @PathVariable Long id) {
        LOGGER.info("Finding Department by ID: {}", id);
        return repository.findById(id);

    }

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees() {
        LOGGER.info("Finding All Departments with employees");
        List<Department> departments = repository.findAll();
        departments.forEach(department -> department.setEmployess(employeeClient.findByDepartmentId(department.getId())));
        return departments;
    }
}
