package com.axonactive.demo.rest;

import com.axonactive.demo.dto.EmployeeDTO;
import com.axonactive.demo.entities.Employee;
import com.axonactive.demo.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeResource implements EmployeeAPI {
    private final EmployeeService employeeService;
    @Override
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @Override
    public ResponseEntity<Employee> createEmployee(EmployeeDTO employeeDTO, Long deptId) {
        Employee employee = employeeService.createEmployee(employeeDTO, deptId);
        return ResponseEntity.created(URI.create("/api/employees" + employee.getEmployeeId())).body(employee);
    }

    @Override
    public ResponseEntity<List<Employee>> getEmployeeByEmployeeId(String employeeId) {
        return ResponseEntity.ok(employeeService.getEmployeeByEmployeeId(employeeId));
    }

    @Override
    public ResponseEntity<Void> deleteEmployeeByEmployeeId(String employeeId) {
        employeeService.deleteEmployeeById(employeeId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Employee> updateDepartment(String employeeId, EmployeeDTO employeeDTO) {
        Employee newEmployee =  employeeService.updateEmployee(employeeId, employeeDTO);
        return ResponseEntity.ok().body(newEmployee);
    }
}
