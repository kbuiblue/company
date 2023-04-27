package com.axonactive.demo.rest;

import com.axonactive.demo.dto.DepartmentLocationDTO;
import com.axonactive.demo.entities.DepartmentLocation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/department-locations")
public interface DepartmentLocationAPI {
    @GetMapping
    ResponseEntity<List<DepartmentLocation>> getAllDepartmentLocation();

    @GetMapping("/ids")
    ResponseEntity<List<DepartmentLocation>> getDepartmentLocationById(@RequestParam("id") Long id);

    @PostMapping
    ResponseEntity<DepartmentLocation> createDepartmentLocation(@RequestBody DepartmentLocationDTO departmentLocationDTO);

    @DeleteMapping
    ResponseEntity<Void> deleteDepartmentLocationById(@RequestParam("id") Long id);

    @PutMapping("/{id}")
    ResponseEntity<DepartmentLocation> updateDepartmentLocation(@PathVariable("id") Long id,
                                                                @RequestBody DepartmentLocationDTO departmentLocationDTO);
}
