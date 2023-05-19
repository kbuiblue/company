package com.axonactive.demo.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class EmployeeServiceTest {
    @Autowired
    private EmployeeService employeeService;

    // 2. Get all employees that have birth months the same with input month
    @Test
    void getAllEmployeeWithSameBirthMonth() {
        Integer birthMonth = 1;
        employeeService.getAllEmployeeWithSameBirthMonth(birthMonth).forEach(System.out::println);
    }
}