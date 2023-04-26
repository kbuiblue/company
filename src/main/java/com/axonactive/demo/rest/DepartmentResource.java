package com.axonactive.demo.rest;

import com.axonactive.demo.dto.DepartmentDTO;
import com.axonactive.demo.entities.Department;

import com.axonactive.demo.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
        return ResponseEntity.created(URI.create("/api/departments/" + department.getDeptId())).body(department);
    }

    @Override
    public ResponseEntity<Optional<Department>> getDepartmentByName(String name) {
        return ResponseEntity.ok(departmentService.getDepartmentByName(name));
    }

    @Override
    public ResponseEntity<List<Department>> getDepartmentByDeptId(Long deptId) {
        return ResponseEntity.ok(departmentService.getDepartmentById(deptId));
    }
    @Override
    public ResponseEntity<Void> deleteDepartment(Long deptId) {
        departmentService.deleteDepartment(deptId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Department> updateDepartment(Long deptId, DepartmentDTO departmentDTO) {
        Department result =  departmentService.updateDepartment(deptId, departmentDTO);
        return ResponseEntity.ok().body(result);
    }

}
