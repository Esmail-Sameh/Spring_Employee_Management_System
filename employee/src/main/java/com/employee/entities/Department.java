package com.employee.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    private UUID departmentId;

    @Column(name = "name", length = 50, nullable = false, unique = true)
    private String name;

    public Department() {
    }

    public Department(UUID departmentId, String name) {
        this.departmentId = departmentId;
        this.name = name;
    }

    public UUID getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(UUID departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
