package com.axonactive.demo.repositories;

import com.axonactive.demo.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> getDepartmentByDeptId(Long deptId);
    List<Department> getDepartmentByName(String name);
    List<Department> getDepartmentByNameAndDeptId(String name, Long deptId);
    List<Department> getDepartmentByNameOrDeptId(String name, Long deptId);
    List<Department> getDepartmentByStartDateAfter(LocalDate date);
    List<Department> getDepartmentByNameContaining(String contain);
    List<Department> getByOrderByNameAsc();
}
