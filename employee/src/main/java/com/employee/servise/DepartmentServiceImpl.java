package com.employee.servise;

import com.employee.abstracts.DepartmentService;
import com.employee.dtos.DepartmentDto;
import com.employee.entities.Department;
import com.employee.repositpories.DepartmentRepo;
import com.employee.shared.CustomResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepo departmentRepo;

    @Override
    public List<Department> findAll() {
        return departmentRepo.findAll();
    }

    @Override
    public Department findOne(UUID departmentId) {
        Department department = departmentRepo.findById(departmentId)
                .orElseThrow(() -> CustomResponseException
                        .ResourceNotFound("Department with id " + departmentId + "not found"));
        return department;
    }

    @Override
    public void deleteOne(UUID departmentId) {
        Department department = departmentRepo.findById(departmentId)
                .orElseThrow(() -> CustomResponseException
                        .ResourceNotFound("Department with id " + departmentId + " not found"));
        departmentRepo.deleteById(department.getDepartmentId());
    }

    @Override
    public Department createOne(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setName(departmentDto.name());
        departmentRepo.save(department);
        return department;
    }

    @Override
    public Department UpdateOne(DepartmentDto departmentDto, UUID departmentId) {
        Department department = departmentRepo.findById(departmentId)
                .orElseThrow(() -> CustomResponseException
                        .ResourceNotFound("Department with id " + departmentId + " not found"));
        department.setName(departmentDto.name());
        departmentRepo.save(department);
        return department;
    }


}
