package com.employee.repositpories;

import com.employee.entities.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LeaveRequestRepo extends JpaRepository<LeaveRequest, UUID> {

    public List<LeaveRequest> findAllByEmployeeId(UUID EmployeeId);
}
