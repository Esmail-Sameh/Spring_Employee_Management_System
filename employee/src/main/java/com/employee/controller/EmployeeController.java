package com.employee.controller;

import com.employee.entities.Employee;
import com.employee.shared.CustomResponseException;
import com.employee.shared.GlobalResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    ArrayList<Employee> employees = new ArrayList<>();

    @GetMapping
    public ResponseEntity<GlobalResponse<ArrayList<Employee>>> findAllEmployee() {
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new GlobalResponse<>(employees), HttpStatus.OK);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<GlobalResponse<Employee>> findOneEmployee(@PathVariable UUID employeeId) {
        Employee employee = employees.stream().filter(
                        emp -> emp.getId().equals(employeeId))
                .findFirst()
                .orElseThrow(() -> CustomResponseException.ResourceNotFound(
                        "Employee with id " + employeeId + " not found"));
        return new ResponseEntity<>(new GlobalResponse<>(employee), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GlobalResponse<Employee>> createEmployee(@RequestBody @Valid Employee employee) {
        employee.setId(UUID.randomUUID());
        employee.setDepartmentId(UUID.randomUUID());
        employees.add(employee);

        return new ResponseEntity<>(new GlobalResponse<>(employee), HttpStatus.CREATED);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable UUID employeeId) {
        Employee employee = employees.stream().filter(
                        emp -> emp.getId().equals(employeeId))
                .findFirst().orElseThrow(() -> CustomResponseException.ResourceNotFound(
                        "Employee with id " + employeeId + " not found"
                ));

        employees.remove(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<GlobalResponse<Employee>> updateEmployee(@RequestBody @Valid Employee employee, @PathVariable UUID employeeId) {
        Employee exEmployee = employees.stream().filter(
                        emp -> emp.getId().equals(employeeId))
                .findFirst().orElseThrow(() -> CustomResponseException.ResourceNotFound(
                        "Employee with id " + employeeId + " not found"
                ));

        exEmployee.setFirstName(employee.getFirstName());
        exEmployee.setLastName(employee.getLastName());
        exEmployee.setEmail(employee.getEmail());
        exEmployee.setPosition(employee.getPosition());
        exEmployee.setHireingDate(employee.getHireingDate());
        exEmployee.setPhone_number(employee.getPhone_number());

        return new ResponseEntity<>(new GlobalResponse<>(exEmployee), HttpStatus.OK);

    }


}
