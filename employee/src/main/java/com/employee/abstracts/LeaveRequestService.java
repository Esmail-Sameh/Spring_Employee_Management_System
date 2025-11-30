package com.employee.abstracts;

import com.employee.dtos.LeaveRequestCreate;
import com.employee.dtos.LeaveRequestUpdate;
import com.employee.entities.LeaveRequest;

import java.util.List;
import java.util.UUID;

public interface LeaveRequestService {

    public List<LeaveRequest> findAllLeaveRequestBYEmployee(UUID employeeId);

    public LeaveRequest updateOneLeaveRequest(UUID leaveReques, LeaveRequestUpdate leaveRequestUpdate);

    public void deleteLeaveRequest(UUID leaveRequestId);

    public LeaveRequest createLeaveRequest(LeaveRequestCreate leaveRequestCreate, UUID employeeId);


}
