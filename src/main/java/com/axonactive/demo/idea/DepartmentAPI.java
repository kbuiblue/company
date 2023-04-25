package com.axonactive.demo.idea;

import com.axonactive.demo.dto.DepartmentDTO;
import com.axonactive.demo.entities.Department;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "/api/departments")
public interface DepartmentAPI {

    @GetMapping
    ResponseEntity<List<Department>> getAllDepartment();

    @PostMapping
    ResponseEntity<Department> createDepartment(@RequestBody DepartmentDTO departmentDTO);

}
