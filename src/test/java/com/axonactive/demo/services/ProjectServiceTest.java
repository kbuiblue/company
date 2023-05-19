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
class ProjectServiceTest {

    @Autowired
    ProjectService projectService;

    //5. List of departments and projects that they manage (-)
    @Test
    void getAllProjectsManagedByEachDepartment() {
        projectService.getAllProjectsManagedByEachDepartment().forEach(System.out::println);
    }
}