package com.employee.controller;

import com.employee.abstracts.EmployeeService;
import com.employee.entities.Employee;
import com.employee.shared.GlobalResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<GlobalResponse<ArrayList<Employee>>> findAllEmployee() {
        ArrayList<Employee> employees = employeeService.findAllEmployee();
        return new ResponseEntity<>(new GlobalResponse<>(employees), HttpStatus.OK);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<GlobalResponse<Employee>> findOneEmployee(@PathVariable UUID employeeId) {
        Employee employee = employeeService.findOneEmployee(employeeId);
        return new ResponseEntity<>(new GlobalResponse<>(employee), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GlobalResponse<Employee>> createEmployee(@RequestBody @Valid Employee employee) {
        Employee newEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(new GlobalResponse<>(newEmployee), HttpStatus.CREATED);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable UUID employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<GlobalResponse<Employee>> updateEmployee(@RequestBody @Valid Employee employee, @PathVariable UUID employeeId) {
        Employee exEmployee = employeeService.updateEmployee(employee, employeeId);

        return new ResponseEntity<>(new GlobalResponse<>(exEmployee), HttpStatus.OK);

    }


}
