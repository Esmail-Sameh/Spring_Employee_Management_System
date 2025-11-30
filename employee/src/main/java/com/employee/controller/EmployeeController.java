package com.employee.controller;

import com.employee.abstracts.EmployeeService;
import com.employee.abstracts.LeaveRequestService;
import com.employee.dtos.EmployeeCreate;
import com.employee.dtos.EmployeeUpdate;
import com.employee.dtos.LeaveRequestCreate;
import com.employee.dtos.LeaveRequestUpdate;
import com.employee.entities.Employee;
import com.employee.entities.LeaveRequest;
import com.employee.shared.GlobalResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private LeaveRequestService leaveRequestService;

    @GetMapping
    public ResponseEntity<GlobalResponse<List<Employee>>> findAllEmployee() {
        List<Employee> employees = employeeService.findAllEmployee();
        return new ResponseEntity<>(new GlobalResponse<>(employees), HttpStatus.OK);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<GlobalResponse<Employee>> findOneEmployee(@PathVariable UUID employeeId) {
        Employee employee = employeeService.findOneEmployee(employeeId);
        return new ResponseEntity<>(new GlobalResponse<>(employee), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GlobalResponse<Employee>> createEmployee(@RequestBody @Valid EmployeeCreate employee) {
        Employee newEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(new GlobalResponse<>(newEmployee), HttpStatus.CREATED);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable UUID employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<GlobalResponse<Employee>> updateEmployee(@RequestBody @Valid EmployeeUpdate employee, @PathVariable UUID employeeId) {
        Employee exEmployee = employeeService.updateEmployee(employee, employeeId);

        return new ResponseEntity<>(new GlobalResponse<>(exEmployee), HttpStatus.OK);
    }

    //***** Leave Request *****//

    @PostMapping("/{employeeId}/leave-request")
    public ResponseEntity<GlobalResponse<LeaveRequest>> createLeaveRequest(
            @RequestBody @Valid LeaveRequestCreate leaveRequestCreate,
            @PathVariable UUID employeeId) {

        LeaveRequest leaveRequest = leaveRequestService.createLeaveRequest(leaveRequestCreate, employeeId);
        return new ResponseEntity<>(new GlobalResponse<>(leaveRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{leaveRequestId}/leave-request")
    public ResponseEntity<GlobalResponse<LeaveRequest>> updateLeaveRequest(
            @RequestBody @Valid LeaveRequestUpdate leaveRequestUpdate,
            @PathVariable UUID leaveRequestId) {

        LeaveRequest leaveRequest = leaveRequestService.updateOneLeaveRequest(leaveRequestId, leaveRequestUpdate);
        return new ResponseEntity<>(new GlobalResponse<>(leaveRequest), HttpStatus.OK);
    }

    @GetMapping("/{employeeId}/leave-request")
    public ResponseEntity<GlobalResponse<List<LeaveRequest>>> findAllLeaveRequestBYEmployee(@PathVariable UUID employeeId) {
        List<LeaveRequest> employeeLeaveRequest = leaveRequestService.findAllLeaveRequestBYEmployee(employeeId);
        return new ResponseEntity<>(new GlobalResponse<>(employeeLeaveRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{leaveRequestId}/leave-request")
    public void deleteLeaveRequest(@PathVariable @Valid UUID leaveRequestId) {
        leaveRequestService.deleteLeaveRequest(leaveRequestId);
    }

}










