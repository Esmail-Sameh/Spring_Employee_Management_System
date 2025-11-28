package com.employee.abstracts;

import com.employee.dtos.DepartmentDto;
import com.employee.entities.Department;

import java.util.List;
import java.util.UUID;

public interface DepartmentService {

    public List<Department> findAll();

    public Department findOne(UUID departmentId);

    public void deleteOne(UUID departmentId);

    public Department createOne(DepartmentDto departmentDto);

    public Department UpdateOne(DepartmentDto departmentDto, UUID departmentId);


}
