package com.employee.servise;

import com.employee.dtos.SignupRequest;
import com.employee.entities.Employee;
import com.employee.entities.UserAccount;
import com.employee.repositpories.AuthRepo;
import com.employee.repositpories.EmployeeRepo;
import com.employee.shared.CustomResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServise {
    @Autowired
    private AuthRepo authRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EmployeeRepo employeeRepo;

    public void signup(SignupRequest authRequest) {

        Employee employee = employeeRepo.findById(authRequest.employeeId())
                .orElseThrow(() -> CustomResponseException.ResourceNotFound(
                        "Employee with id " + authRequest.employeeId() + " not found"));

        UserAccount userAccount = new UserAccount();
        userAccount.setUserName(authRequest.userName());
        userAccount.setPassword(passwordEncoder.encode(authRequest.password()));
        userAccount.setEmployee(employee);
        authRepo.save(userAccount);
    }

}
