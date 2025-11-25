package com.employee.servise;

import com.employee.abstracts.EmployeeService;
import com.employee.dtos.EmployeeCreate;
import com.employee.dtos.EmployeeUpdate;
import com.employee.entities.Employee;
import com.employee.repositpories.EmployeeRepo;
import com.employee.shared.CustomResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;
    ArrayList<Employee> employees = new ArrayList<>();

    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findOneEmployee(UUID employeeId) {
        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> CustomResponseException.ResourceNotFound(
                        "Employee with id " + employeeId + " not found"));
        return employee;
    }

    @Override
    public Employee createEmployee(EmployeeCreate employeeCreate) {
        Employee employee = new Employee();
        employee.setEmail(employeeCreate.email());
        employee.setFirstName(employeeCreate.firstName());
        employee.setLastName(employeeCreate.lastName());
        employee.setPosition(employeeCreate.position());
        employee.setHireingDate(employeeCreate.hireingDate());
        employee.setPhone_number(employeeCreate.phone_number());

        employeeRepo.save(employee);


        return employee;
    }

    @Override
    public void deleteEmployee(UUID employeeId) {
        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> CustomResponseException.ResourceNotFound(
                        "Employee with id " + employeeId + " not found"
                ));
        employeeRepo.deleteById(employee.getId());
    }

    @Override
    public Employee updateEmployee(EmployeeUpdate employeeUpdate, UUID employeeId) {
        Employee exEmployee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> CustomResponseException.ResourceNotFound(
                        "Employee with id " + employeeId + " not found"
                ));
        exEmployee.setFirstName(employeeUpdate.firstName());
        exEmployee.setLastName(employeeUpdate.lastName());
        exEmployee.setPosition(employeeUpdate.position());
        exEmployee.setPhone_number(employeeUpdate.phone_number());
        employeeRepo.save(exEmployee);

        return exEmployee;
    }
}
