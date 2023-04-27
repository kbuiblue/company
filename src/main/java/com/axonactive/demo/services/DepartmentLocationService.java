package com.axonactive.demo.services;

import com.axonactive.demo.dto.DepartmentLocationDTO;
import com.axonactive.demo.entities.DepartmentLocation;
import com.axonactive.demo.repositories.DepartmentLocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentLocationService {
    private final DepartmentLocationRepository departmentLocationRepository;

    public List<DepartmentLocation> getAllDepartmentLocation() {
        return departmentLocationRepository.findAll();
    }

    public List<DepartmentLocation> getDepartmentLocationById(Long id) {
        return departmentLocationRepository.getDepartmentLocationById(id);
    }
    public DepartmentLocation createDepartmentLocation(DepartmentLocationDTO departmentLocationDTO) {
        DepartmentLocation departmentLocation = new DepartmentLocation();
        departmentLocation.setLocation(departmentLocationDTO.getLocation());
        return departmentLocationRepository.save(departmentLocation);
    }
}
