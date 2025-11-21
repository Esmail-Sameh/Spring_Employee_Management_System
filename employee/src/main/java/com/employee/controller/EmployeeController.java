package com.employee.controller;

import com.employee.entities.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    ArrayList<Employee> employees = new ArrayList<>();

    @GetMapping
    public ArrayList<Employee> findAll() {
        return employees;
    }

    @GetMapping("/{employeeId}")
    public Optional<Employee> findOne(@PathVariable UUID employeeId) {
        Optional<Employee> employee = employees.stream().filter(
                emp -> emp.getId().equals(employeeId)).findFirst();
        return employee;
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        employee.setId(UUID.randomUUID());
        employee.setDepartmentId(UUID.randomUUID());
        employees.add(employee);
        return employee;
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable UUID employeeId) {
        Optional<Employee> employee = employees.stream().filter(
                emp -> emp.getId().equals(employeeId)).findFirst();
        if (employee.isPresent()) {
            employees.remove(employee.get());
        }
    }

    @PutMapping("/{employeeId}")
    public Optional<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable UUID employeeId) {
        Optional<Employee> exEmployee = employees.stream().filter(
                emp -> emp.getId().equals(employeeId)).findFirst();
        if (exEmployee.isPresent()) {
            exEmployee.get().setFirstName(employee.getFirstName());
            exEmployee.get().setLastName(employee.getLastName());
            exEmployee.get().setEmail(employee.getEmail());
            exEmployee.get().setPosition(employee.getPosition());
            exEmployee.get().setHireingDate(employee.getHireingDate());
            exEmployee.get().setPhone_number(employee.getPhone_number());
        }
        return exEmployee;

    }


}
