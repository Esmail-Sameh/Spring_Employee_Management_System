package com.employee.dtos;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record LeaveRequestCreate(
        @NotNull(message = "Reason is required")
        @Size(min = 2, max = 50, message = "min is 2 and max is 50")
        String reason,

        @NotNull(message = "Start date is required")
        @FutureOrPresent(message = "start date should be now or in the future")
        LocalDate startDate,

        @NotNull(message = "End date is required")
        @FutureOrPresent(message = "end date should be now or in the future")
        LocalDate endDate
) {
}
