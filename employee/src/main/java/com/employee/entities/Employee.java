package com.employee.entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class Employee {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone_number;
    private LocalDate hireingDate;
    private String position;
    private UUID departmentId;

    public Employee(UUID id, String firstName, String lastName, String email, String phone_number, LocalDate hireingDate, String position, UUID departmentId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone_number = phone_number;
        this.hireingDate = hireingDate;
        this.position = position;
        this.departmentId = departmentId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public UUID getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(UUID departmentId) {
        this.departmentId = departmentId;
    }

    public LocalDate getHireingDate() {
        return hireingDate;
    }

    public void setHireingDate(LocalDate hireingDate) {
        this.hireingDate = hireingDate;
    }



}
