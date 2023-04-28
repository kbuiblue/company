package com.axonactive.demo.rest;

import com.axonactive.demo.dto.DepartmentDTO;
import com.axonactive.demo.entities.Department;

import com.axonactive.demo.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentResource implements DepartmentAPI{

    private final DepartmentService departmentService;
    @Override
    public ResponseEntity<List<Department>> getAllDepartment() {
        return ResponseEntity.ok(departmentService.getAllDepartment());
    }
    @Override
    public ResponseEntity<Department> createDepartment(DepartmentDTO departmentDTO) {
        Department department = departmentService.createDepartment(departmentDTO);
        return ResponseEntity.created(URI.create("/api/departments" + department.getDeptId())).body(department);
    }

    @Override
    public ResponseEntity<List<Department>> getDepartmentByName(String name) {
        return ResponseEntity.ok(departmentService.getDepartmentByName(name));
    }

    @Override
    public ResponseEntity<List<Department>> getDepartmentByDeptId(Long deptId) {
        return ResponseEntity.ok(departmentService.getDepartmentById(deptId));
    }

    @Override
    public ResponseEntity<List<Department>> getDepartmentByNameAndDeptId(String name, Long deptId) {
        return ResponseEntity.ok(departmentService.getDepartmentByNameAndDeptId(name, deptId));
    }
    @Override
    public ResponseEntity<List<Department>> getDepartmentByNameOrDeptId(String name, Long deptId) {
        return ResponseEntity.ok(departmentService.getDepartmentByNameOrDeptId(name, deptId));
    }

    @Override
    public ResponseEntity<List<Department>> getDepartmentByStartDateAfter(LocalDate date) {
        return ResponseEntity.ok(departmentService.getDepartmentByStartDateAfter(date));
    }

    @Override
    public ResponseEntity<Void> deleteDepartmentById(Long deptId) {
        departmentService.deleteDepartmentById(deptId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Department> updateDepartment(Long deptId, DepartmentDTO departmentDTO) {
        Department newDepartment =  departmentService.updateDepartment(deptId, departmentDTO);
        return ResponseEntity.ok().body(newDepartment);
    }

    @Override
    public ResponseEntity<List<Department>> getDepartmentByNameContaining(String contain) {
        return ResponseEntity.ok(departmentService.getDepartmentByNameContaining(contain));
    }

    @Override
    public ResponseEntity<List<Department>> getByOrderByNameAsc() {
        return ResponseEntity.ok(departmentService.getByOrderByNameAsc());
    }
}
