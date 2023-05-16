package com.axonactive.demo.services;

import com.axonactive.demo.dto.DepartmentDTO;
import com.axonactive.demo.entities.Department;
import com.axonactive.demo.repositories.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<Department> getDepartmentByNameAndDeptId(String name, Long deptId) {
        return departmentRepository.getDepartmentByNameAndDeptId(name, deptId);
    }
    public List<Department> getDepartmentByNameOrDeptId(String name, Long deptId) {
        return departmentRepository.getDepartmentByNameOrDeptId(name, deptId);
    }

    public List<Department> getDepartmentByStartDateAfter(LocalDate date) {
        return departmentRepository.getDepartmentByStartDateAfter(date);
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

    public List<Department> getDepartmentByNameContaining(String contain) {
        return departmentRepository.getDepartmentByNameContaining(contain);
    }

    public List<Department> getByOrderByNameAsc() {
        return departmentRepository.getByOrderByNameAsc();
    }

    public List<String> getDepartmentStatisticsReport() {
        List<Department> departmentList = getAllDepartment();

        return departmentList.stream()
                .map(department -> department.getName() + ", " + department.getStartDate())
                .collect(Collectors.toList());
    }

}
