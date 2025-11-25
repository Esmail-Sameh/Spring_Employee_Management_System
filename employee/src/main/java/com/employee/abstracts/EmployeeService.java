package com.employee.abstracts;

import com.employee.dtos.EmployeeCreate;
import com.employee.dtos.EmployeeUpdate;
import com.employee.entities.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    public List<Employee> findAllEmployee();

    public Employee findOneEmployee(UUID employeeId);

    public Employee createEmployee(EmployeeCreate employee);

    public void deleteEmployee(UUID employeeId);

    public Employee updateEmployee(EmployeeUpdate employee, UUID employeeId);

}
