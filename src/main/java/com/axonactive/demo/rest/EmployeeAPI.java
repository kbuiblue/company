package com.axonactive.demo.rest;

import com.axonactive.demo.dto.EmployeeDTO;
import com.axonactive.demo.entities.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/employees")
public interface EmployeeAPI {
    @GetMapping
    ResponseEntity<List<Employee>> getAllEmployee();

    @GetMapping("/employee-ids")
    ResponseEntity<List<Employee>> getEmployeeByEmployeeId(@RequestParam("employeeId") String employeeId);

    @PostMapping
    ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDTO employeeDTO);

    @DeleteMapping
    ResponseEntity<Void> deleteEmployeeByEmployeeId(@RequestParam("employeeId") String employeeId);

    @PutMapping("/{employeeId}")
    ResponseEntity<Employee> updateDepartment(@PathVariable("employeeId")  String employeeId,
                                              @RequestBody EmployeeDTO employeeDTO);
}
