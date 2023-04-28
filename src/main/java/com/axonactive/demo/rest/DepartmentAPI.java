package com.axonactive.demo.rest;

import com.axonactive.demo.dto.DepartmentDTO;
import com.axonactive.demo.entities.Department;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping(value = "/api/departments")
public interface DepartmentAPI {

    @GetMapping
    ResponseEntity<List<Department>> getAllDepartment();

    @GetMapping("/deptIds")
    ResponseEntity<List<Department>> getDepartmentByDeptId(@RequestParam("deptId") Long deptId);

    @GetMapping("/names")
    ResponseEntity<List<Department>> getDepartmentByName(@RequestParam("name") String name);

    @GetMapping("/namesAndIds")
    ResponseEntity<List<Department>> getDepartmentByNameAndDeptId(@RequestParam("name") String name,
                                                                  @RequestParam("deptId") Long deptId);

    @GetMapping("/namesOrIds")
    ResponseEntity<List<Department>> getDepartmentByNameOrDeptId(@RequestParam("name") String name,
                                                                  @RequestParam("deptId") Long deptId);

    @GetMapping("/startDateAfter")
    ResponseEntity<List<Department>> getDepartmentByStartDateAfter(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date);

    @PostMapping
    ResponseEntity<Department> createDepartment(@RequestBody DepartmentDTO departmentDTO);

    @DeleteMapping
    ResponseEntity<Void> deleteDepartmentById(@RequestParam("deptId") Long deptId);

    @PutMapping("/{deptId}")
    ResponseEntity<Department> updateDepartment(@PathVariable("deptId") Long deptId,
                                                @RequestBody DepartmentDTO departmentDTO);
    @GetMapping("/nameContains")
    ResponseEntity<List<Department>> getDepartmentByNameContaining(@RequestParam("contain") String contain);

    @GetMapping("/nameAsc")
    ResponseEntity<List<Department>> getByOrderByNameAsc();
}
