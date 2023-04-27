package com.axonactive.demo.services;

import com.axonactive.demo.dto.AssignmentDTO;
import com.axonactive.demo.dto.DepartmentLocationDTO;
import com.axonactive.demo.entities.Assignment;
import com.axonactive.demo.entities.DepartmentLocation;
import com.axonactive.demo.repositories.DepartmentLocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void deleteDepartmentLocationById(Long id) {
        departmentLocationRepository.deleteById(id);
    }

    public DepartmentLocation updateDepartmentLocation(Long id, DepartmentLocationDTO departmentLocationDTO) {
        Optional<DepartmentLocation> newDepartmentLocation = departmentLocationRepository.findById(id);
        DepartmentLocation updatedAssignment = newDepartmentLocation.get();
        updatedAssignment.setLocation(departmentLocationDTO.getLocation());
        return departmentLocationRepository.save(updatedAssignment);
    }

}
