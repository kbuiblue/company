package com.axonactive.demo.idea;

import com.axonactive.demo.dto.DepartmentDTO;
import com.axonactive.demo.entities.Department;

import com.axonactive.demo.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentResource implements DepartmentAPI{

    private final DepartmentService departmentService;
    @Override
    public ResponseEntity<List<Department>> getAllDepartment() {
        return ResponseEntity.ok(departmentService.getAllDeparment());
    }
    @Override
    public ResponseEntity<Department> createDepartment(DepartmentDTO departmentDTO) {
        Department department = departmentService.setName(departmentDTO);
        return ResponseEntity.created(URI.create("/api/departments/" + department.getDepartmentId())).body(department);
    }
}
