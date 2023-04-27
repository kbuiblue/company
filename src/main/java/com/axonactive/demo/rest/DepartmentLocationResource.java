package com.axonactive.demo.rest;

import com.axonactive.demo.dto.DepartmentLocationDTO;
import com.axonactive.demo.entities.Department;
import com.axonactive.demo.entities.DepartmentLocation;
import com.axonactive.demo.services.DepartmentLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
@RestController
@RequiredArgsConstructor
public class DepartmentLocationResource implements DepartmentLocationAPI {

    private final DepartmentLocationService departmentLocationService;

    @Override
    public ResponseEntity<List<DepartmentLocation>> getAllDepartmentLocation() {
        return ResponseEntity.ok(departmentLocationService.getAllDepartmentLocation());
    }

    @Override
    public ResponseEntity<DepartmentLocation> createDepartmentLocation(DepartmentLocationDTO departmentLocationDTO) {
        DepartmentLocation departmentLocation = departmentLocationService.createDepartmentLocation(departmentLocationDTO);
        return ResponseEntity.created(URI.create("/api/department-locations" + departmentLocation.getLocationId())).body(departmentLocation);
    }

    @Override
    public ResponseEntity<List<DepartmentLocation>> getDepartmentLocationById(Long id) {
        return ResponseEntity.ok(departmentLocationService.getDepartmentLocationById(id));
    }

    @Override
    public ResponseEntity<Void> deleteDepartmentLocationById(Long id) {
        departmentLocationService.deleteDepartmentLocationById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<DepartmentLocation> updateDepartmentLocation(Long id, DepartmentLocationDTO departmentLocationDTO) {
        DepartmentLocation newDepartmentLocation =  departmentLocationService.updateDepartmentLocation(id, departmentLocationDTO);
        return ResponseEntity.ok().body(newDepartmentLocation);
    }
}
