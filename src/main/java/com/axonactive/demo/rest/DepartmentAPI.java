package com.axonactive.demo.rest;

import com.axonactive.demo.dto.DepartmentDTO;
import com.axonactive.demo.entities.Department;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/api/departments")
public interface DepartmentAPI {

    @GetMapping
    ResponseEntity<List<Department>> getAllDepartment();

    @GetMapping("/dept-ids")
    ResponseEntity<List<Department>> getDepartmentByDeptId(@RequestParam("deptId") Long deptId);

    @GetMapping("/names")
    ResponseEntity<List<Department>> getDepartmentByName(@RequestParam("name") String name);

    @PostMapping
    ResponseEntity<Department> createDepartment(@RequestBody DepartmentDTO departmentDTO);

    @DeleteMapping
    ResponseEntity<Void> deleteDepartmentById(@RequestParam("deptId") Long deptId);

    @PutMapping("/{deptId}")
    ResponseEntity<Department> updateDepartment(@PathVariable("deptId") Long deptId,
                                                @RequestBody DepartmentDTO departmentDTO);
}
