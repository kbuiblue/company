package com.axonactive.demo.repositories;

import com.axonactive.demo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    List<Employee> getEmployeeByEmployeeId(String employeeId);
}