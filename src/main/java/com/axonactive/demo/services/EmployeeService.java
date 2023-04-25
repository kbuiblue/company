package com.axonactive.demo.services;

import com.axonactive.demo.dto.EmployeeDTO;
import com.axonactive.demo.entities.Employee;
import com.axonactive.demo.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee setDateOfBirth(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
        return employeeRepository.save(employee);
    }

    public Employee setFirstName(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setFirstName(employeeDTO.getFirstName());
        return employeeRepository.save(employee);
    }

    public Employee setMiddleName(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setMiddleName(employeeDTO.getMiddleName());
        return employeeRepository.save(employee);
    }

    public Employee setLastName(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setLastName(employeeDTO.getLastName());
        return employeeRepository.save(employee);
    }

    public Employee setSalary(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setSalary(employeeDTO.getSalary());
        return employeeRepository.save(employee);
    }
}
