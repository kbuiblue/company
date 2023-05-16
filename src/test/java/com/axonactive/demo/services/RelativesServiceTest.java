package com.axonactive.demo.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class RelativesServiceTest {

    @Autowired
    RelativesService relativesService;
    @Test
    void getEmployeeRelatives() {
        String employeeId = "odiwellf";
        relativesService.getEmployeeRelatives(employeeId).forEach(System.out::println);
    }

    @Test
    void getEmployeeWithEmergencyContact() {
        System.out.println(relativesService.getEmployeeWithEmergencyContact());
    }
}