package com.vikastech.employee_service.repository;

import com.vikastech.employee_service.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    private List<Employee> employees = new ArrayList<>();

    public Employee add(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Employee findById(Long id) {
        return employees.stream()
                .filter(a-> a.id().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Employee> findAll() {
        return employees;
    }

    public  List<Employee> findByDepartmentId(Long departmentId) {
        return employees.stream()
                .filter(a-> a.departmentId().equals((departmentId)))
                .toList();
    }
}
