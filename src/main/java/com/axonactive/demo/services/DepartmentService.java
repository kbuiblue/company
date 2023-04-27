package com.axonactive.demo.services;

import com.axonactive.demo.dto.DepartmentDTO;
import com.axonactive.demo.entities.Department;
import com.axonactive.demo.repositories.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    public List<Department> getDepartmentById(Long deptId) {
        return departmentRepository.getDepartmentByDeptId(deptId);
    }

    public Department createDepartment(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setName(departmentDTO.getName());
        department.setStartDate(departmentDTO.getStartDate());
        return departmentRepository.save(department);
    }
    public List<Department> getDepartmentByName(String name){
        return departmentRepository.getDepartmentByName(name);
    }

    public void deleteDepartmentById(Long deptId) {
        departmentRepository.deleteById(deptId);
    }

    public Department updateDepartment(Long deptId, DepartmentDTO departmentDTO) {
        Optional<Department> department = departmentRepository.findById(deptId);
        Department updatedDepartment = department.get();
        updatedDepartment.setName(departmentDTO.getName());
        updatedDepartment.setStartDate(departmentDTO.getStartDate());
        return departmentRepository.save(updatedDepartment);
    }

}
