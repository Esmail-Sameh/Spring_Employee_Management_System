package com.employee.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "user-account")
public class UserAccount {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    private UUID id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private String role = "USER";

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employeeId", unique = true, nullable = false)
    @JsonProperty("employeeId")
    private Employee employee;

    public UserAccount() {
    }

    public UserAccount(UUID id, String userName, String role, String password, Employee employee) {
        this.id = id;
        this.userName = userName;
        this.role = role;
        this.password = password;
        this.employee = employee;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UUID getEmployee() {
        return employee.getId();
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


}
