package com.employee.abstracts;

import com.employee.entities.Employee;

import java.util.ArrayList;
import java.util.UUID;

public interface EmployeeService {

    public ArrayList<Employee> findAllEmployee();

    public Employee findOneEmployee(UUID employeeId);

    public Employee createEmployee(Employee employee);

    public void deleteEmployee(UUID employeeId);

    public Employee updateEmployee(Employee employee, UUID employeeId);

}
