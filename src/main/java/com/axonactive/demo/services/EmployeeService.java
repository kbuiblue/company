package com.axonactive.demo.services;

import com.axonactive.demo.dto.EmployeeDTO;
import com.axonactive.demo.entities.Department;
import com.axonactive.demo.entities.Employee;
import com.axonactive.demo.entities.Relatives;
import com.axonactive.demo.repositories.DepartmentRepository;
import com.axonactive.demo.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(EmployeeDTO employeeDTO, Long deptId) {
        Optional<Department> department = departmentRepository.findById(deptId);

        Employee employee = new Employee();
        employee.setEmployeeId(employeeDTO.getEmployeeId());
        employee.setGender(employeeDTO.getGender());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setMiddleName(employeeDTO.getMiddleName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
        employee.setSalary(employeeDTO.getSalary());

        department.ifPresent(employee::setDeptId);

        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployeeByEmployeeId(String employeeId) {
        return employeeRepository.getEmployeeByEmployeeId(employeeId);
    }

    public void deleteEmployeeById(String employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public Employee updateEmployee(String employeeId, EmployeeDTO employeeDTO) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);

        Employee updatedEmployee = employee.get();
        updatedEmployee.setFirstName(employeeDTO.getFirstName());
        updatedEmployee.setMiddleName(employeeDTO.getMiddleName());
        updatedEmployee.setLastName(employeeDTO.getLastName());
        updatedEmployee.setDateOfBirth(employeeDTO.getDateOfBirth());
        updatedEmployee.setGender(employeeDTO.getGender());
        updatedEmployee.setSalary(employeeDTO.getSalary());

        return employeeRepository.save(updatedEmployee);
    }

    public List<Employee> getAllEmployeeWithSameBirthMonth(Integer birthMonth) {
        List<Employee> employeeList = getAllEmployee();

        List<Employee> filteredList = employeeList.stream()
                .filter(employee -> employee.getDateOfBirth().getMonthValue() == birthMonth)
                .collect(Collectors.toList());

        return filteredList;
    }


}
