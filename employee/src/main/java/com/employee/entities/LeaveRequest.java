package com.employee.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "leave_request")
public class LeaveRequest {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    private UUID leaveRequestId;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "reason", nullable = false)
    private String reason;

    @Column(name = "status", nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    public LeaveRequest() {
    }

    public LeaveRequest(UUID leaveRequestId, LocalDate startDate, LocalDate endDate, String reason, Employee employee, String status) {
        this.leaveRequestId = leaveRequestId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.employee = employee;
        this.status = status;
    }

    public UUID getLeaveRequestId() {
        return leaveRequestId;
    }

    public void setLeaveRequestId(UUID leaveRequestId) {
        this.leaveRequestId = leaveRequestId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UUID getEmployee() {
        return employee.getId();
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


}
