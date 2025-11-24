package com.employee.servise;

import com.employee.abstracts.EmployeeService;
import com.employee.entities.Employee;
import com.employee.shared.CustomResponseException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    ArrayList<Employee> employees = new ArrayList<>();

    @Override
    public ArrayList<Employee> findAllEmployee() {
        return employees;
    }

    @Override
    public Employee findOneEmployee(UUID employeeId) {
        Employee employee = employees.stream().filter(
                        emp -> emp.getId().equals(employeeId))
                .findFirst()
                .orElseThrow(() -> CustomResponseException.ResourceNotFound(
                        "Employee with id " + employeeId + " not found"));

        return employee;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        employee.setId(UUID.randomUUID());
        employee.setDepartmentId(UUID.randomUUID());
        employees.add(employee);

        return employee;
    }

    @Override
    public void deleteEmployee(UUID employeeId) {
        Employee employee = employees.stream().filter(
                        emp -> emp.getId().equals(employeeId))
                .findFirst().orElseThrow(() -> CustomResponseException.ResourceNotFound(
                        "Employee with id " + employeeId + " not found"
                ));
        employees.remove(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, UUID employeeId) {
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

        return exEmployee;
    }
}
