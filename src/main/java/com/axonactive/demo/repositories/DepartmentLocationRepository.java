package com.axonactive.demo.repositories;

import com.axonactive.demo.entities.DepartmentLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentLocationRepository extends JpaRepository<DepartmentLocation, Long> {
    List<DepartmentLocation> getDepartmentLocationById(Long id);
}
