package com.employee.controller;

import com.employee.entities.Employee;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    ArrayList<Employee> employees = new ArrayList<>();

    @GetMapping
    public ResponseEntity<ArrayList<Employee>> findAll() {
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ArrayList<Employee>>(employees, HttpStatus.OK);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> findOne(@PathVariable UUID employeeId) {
        Optional<Employee> employee = employees.stream().filter(
                emp -> emp.getId().equals(employeeId)).findFirst();

        if (employee.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employee>(employee.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody @Valid Employee employee) {
        employee.setId(UUID.randomUUID());
        employee.setDepartmentId(UUID.randomUUID());
        employees.add(employee);

        return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable UUID employeeId) {
        Optional<Employee> employee = employees.stream().filter(
                emp -> emp.getId().equals(employeeId)).findFirst();
        if (employee.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (employee.isPresent()) {
            employees.remove(employee.get());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody @Valid Employee employee, @PathVariable UUID employeeId) {
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
        return new ResponseEntity<Employee>(exEmployee.get(), HttpStatus.OK);

    }


}
