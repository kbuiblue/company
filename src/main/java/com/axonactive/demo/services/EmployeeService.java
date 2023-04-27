package com.axonactive.demo.services;

import com.axonactive.demo.dto.EmployeeDTO;
import com.axonactive.demo.entities.Employee;
import com.axonactive.demo.entities.Gender;
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

    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setEmployeeId(employeeDTO.getEmployeeId());
        employee.setGender(employeeDTO.getGender());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setMiddleName(employeeDTO.getMiddleName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
        employee.setSalary(employeeDTO.getSalary());
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployeeByEmployeeId(String employeeId) {
        return employeeRepository.getEmployeeByEmployeeId(employeeId);
    }
}
