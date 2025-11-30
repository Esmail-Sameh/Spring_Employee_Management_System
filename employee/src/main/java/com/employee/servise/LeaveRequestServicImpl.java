package com.employee.servise;

import com.employee.abstracts.LeaveRequestService;
import com.employee.dtos.LeaveRequestCreate;
import com.employee.dtos.LeaveRequestUpdate;
import com.employee.entities.Employee;
import com.employee.entities.LeaveRequest;
import com.employee.repositpories.EmployeeRepo;
import com.employee.repositpories.LeaveRequestRepo;
import com.employee.shared.CustomResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LeaveRequestServicImpl implements LeaveRequestService {

    @Autowired
    private LeaveRequestRepo leaveRequestRepo;
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<LeaveRequest> findAllLeaveRequestBYEmployee(UUID employeeId) {
        return leaveRequestRepo.findAllByEmployeeId(employeeId);
    }

    @Override
    public LeaveRequest updateOneLeaveRequest(UUID leaveRequest, LeaveRequestUpdate leaveRequestUpdate) {

        LeaveRequest newleaveRequest = leaveRequestRepo.findById(leaveRequest).
                orElseThrow(() -> CustomResponseException.ResourceNotFound(
                        "Leave request with id " + leaveRequest + "nor found"));

        newleaveRequest.setStartDate(leaveRequestUpdate.startDate());
        newleaveRequest.setEndDate(leaveRequestUpdate.endDate());
        newleaveRequest.setReason(leaveRequestUpdate.reason());
        leaveRequestRepo.save(newleaveRequest);

        return newleaveRequest;
    }

    @Override
    public void deleteLeaveRequest(UUID leaveRequestId) {
        leaveRequestRepo.deleteById(leaveRequestId);
    }

    @Override
    public LeaveRequest createLeaveRequest(
            LeaveRequestCreate leaveRequestCreate,
            UUID employeeId) {
        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> CustomResponseException
                        .ResourceNotFound("Employee with id " + employeeId + " not found"));

        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setStartDate(leaveRequestCreate.startDate());
        leaveRequest.setEndDate(leaveRequestCreate.endDate());
        leaveRequest.setReason(leaveRequestCreate.reason());
        leaveRequest.setStatus("PENDING");
        leaveRequest.setEmployee(employee);
        leaveRequestRepo.save(leaveRequest);
        return leaveRequest;
    }

}
