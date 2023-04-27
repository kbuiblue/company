package com.axonactive.demo.rest;

import com.axonactive.demo.dto.AssignmentDTO;
import com.axonactive.demo.entities.Assignment;
import com.axonactive.demo.services.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AssignmentResource implements AssignmentAPI{
    public final AssignmentService assignmentService;

    @Override
    public ResponseEntity<List<Assignment>> getAllAssignment() {
        return ResponseEntity.ok(assignmentService.getAllAssignment());
    }

    @Override
    public ResponseEntity<Assignment> createAssignment(AssignmentDTO assignmentDTO) {
        Assignment assignment = assignmentService.createAssignment(assignmentDTO);
        return ResponseEntity.created(URI.create("/api/assignments" + assignment.getId())).body(assignment);
    }

    @Override
    public ResponseEntity<List<Assignment>> getAssignmentById(Long id) {
        return ResponseEntity.ok(assignmentService.getAssignmentById(id));
    }

    @Override
    public ResponseEntity<Void> deleteAssignmentById(Long id) {
        assignmentService.deleteAssignmentById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Assignment> updateAssignment(Long id, AssignmentDTO assignmentDTO) {
        Assignment newAssignment = assignmentService.updateAssignment(id, assignmentDTO);
        return ResponseEntity.ok().body(newAssignment);
    }
}
