package com.employee.controller;

import com.employee.abstracts.DepartmentService;
import com.employee.dtos.DepartmentDto;
import com.employee.entities.Department;
import com.employee.shared.GlobalResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<GlobalResponse<List<Department>>> findAllDepartment() {
        List<Department> departments = departmentService.findAll();
        return new ResponseEntity<>(new GlobalResponse<>(departments), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GlobalResponse<Department>> createOneDepartment(@RequestBody @Valid DepartmentDto department) {
        Department newDepartment = departmentService.createOne(department);
        return new ResponseEntity<>(new GlobalResponse<>(newDepartment), HttpStatus.CREATED);
    }

    @DeleteMapping("/{departmentId}")
    public void deleteOne(@PathVariable UUID departmentId) {
        departmentService.deleteOne(departmentId);
    }

    @PutMapping("/{departmentId}")
    public ResponseEntity<GlobalResponse<Department>> updateOne(
            @RequestBody @Valid DepartmentDto department,
            @PathVariable UUID departmentId) {
        Department updeteDepartment = departmentService.UpdateOne(department, departmentId);
        return new ResponseEntity<>(new GlobalResponse<>(updeteDepartment), HttpStatus.OK);
    }


}
