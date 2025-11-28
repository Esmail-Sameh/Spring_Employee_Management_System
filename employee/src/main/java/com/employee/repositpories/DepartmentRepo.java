package com.employee.repositpories;

import com.employee.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DepartmentRepo extends JpaRepository<Department, UUID> {

}
