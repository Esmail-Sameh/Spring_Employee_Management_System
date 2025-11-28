package com.employee.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DepartmentDto(

        @NotNull(message = "name is  required")
        @Size(min = 2, max = 50, message = "min is 2 and max is 50")
        String name
) {
}
