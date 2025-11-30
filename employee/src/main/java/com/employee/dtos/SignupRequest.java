package com.employee.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record SignupRequest(

        @NotNull(message = "User name is required")
        @Size(min = 2, max = 50, message = "min is 2 and max is 50")
        String userName,

        @NotNull(message = "Password is required")
        @Size(min = 2, max = 50, message = "min is 2 and max is 50")
        String password,

        @NotNull(message = "Employee id is required")
        UUID employeeId

) {
}
