package com.axonactive.demo.services;

import com.axonactive.demo.dto.DepartmentDTO;
import com.axonactive.demo.entities.Department;
import com.axonactive.demo.repositories.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public List<Department> getAllDeparment() {
        return departmentRepository.findAll();
    }

    public Department setName(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setDepartmentName(departmentDTO.getName());
        return departmentRepository.save(department);
    }
}
