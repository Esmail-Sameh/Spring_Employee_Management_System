package com.employee.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record EmployeeUpdate(
        @NotNull(message = "First name is required")
        @Size(min = 2, max = 50, message = "min is 2 and max is 50")
        String firstName,

        @NotNull(message = "Last name is required")
        @Size(min = 2, max = 50, message = "min is 2 characters and max is 50 characters")
        String lastName,

        @NotNull(message = "phone_number is required")
        @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid phone number")
        String phone_number,

        @NotNull(message = "Position is required")
        @Size(min = 2, max = 50, message = "min is 2 characters and max is 50 characters")
        String position
) {
}
