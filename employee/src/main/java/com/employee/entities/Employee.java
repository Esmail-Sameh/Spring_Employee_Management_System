package com.employee.entities;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.UUID;

public class Employee {

    private UUID id;

    @NotNull(message = "First name is required")
    @Size(min = 2, max = 50, message = "min is 2 and max is 50")
    private String firstName;

    @NotNull(message = "Last name is required")
    @Size(min = 2, max = 50, message = "min is 2 characters and max is 50 characters")
    private String lastName;

    @NotNull(message = "email is required")
    @Email(message = "Invalid Email format")
    private String email;

    @NotNull(message = "phone_number is required")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid phone number")
    private String phone_number;

    @NotNull(message = "hireingDate is required")
    @PastOrPresent(message = "Hire date cannot be in the future")
    private LocalDate hireingDate;

    @NotNull(message = "Position is required")
    @Size(min = 2, max = 50, message = "min is 2 characters and max is 50 characters")
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
