package com.employee.dtos;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.UUID;

public record EmployeeCreate(
        @NotNull(message = "First name is required")
        @Size(min = 2, max = 50, message = "min is 2 and max is 50")
        String firstName,

        @NotNull(message = "Last name is required")
        @Size(min = 2, max = 50, message = "min is 2 characters and max is 50 characters")
        String lastName,

        @NotNull(message = "email is required")
        @Email(message = "Invalid Email format")
        String email,

        @NotNull(message = "phone_number is required")
        @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid phone number")
        String phone_number,

        @NotNull(message = "hireingDate is required")
        @PastOrPresent(message = "Hire date cannot be in the future")
        LocalDate hireingDate,

        @NotNull(message = "Position is required")
        @Size(min = 2, max = 50, message = "min is 2 characters and max is 50 characters")
        String position,

        @NotNull(message = "DepartmentId is required")
        UUID departmentId
) {
}
