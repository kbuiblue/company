package com.axonactive.demo.repositories;

import com.axonactive.demo.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> getDepartmentByDeptId(Long deptId);
    List<Department> getDepartmentByName(String name);
}
