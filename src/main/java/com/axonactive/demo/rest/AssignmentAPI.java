package com.axonactive.demo.rest;

import com.axonactive.demo.dto.AssignmentDTO;
import com.axonactive.demo.entities.Assignment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/assignments")
public interface AssignmentAPI {
    @GetMapping
    ResponseEntity<List<Assignment>> getAllAssignment();

    @PostMapping
    ResponseEntity<Assignment> createAssignment(@RequestBody AssignmentDTO assignmentDTO);

    @GetMapping("/assignment-ids")
    ResponseEntity<List<Assignment>> getAssignmentById(@RequestParam("id") Long id);

    @DeleteMapping
    ResponseEntity<Void> deleteAssignmentById(@RequestParam("id") Long id);

    @PutMapping("/{id}")
    ResponseEntity<Assignment> updateAssignment(@PathVariable("id") Long id,
                                                @RequestBody AssignmentDTO assignmentDTO);

}
