package com.axonactive.demo.services;

import com.axonactive.demo.dto.AssignmentDTO;
import com.axonactive.demo.entities.Assignment;
import com.axonactive.demo.repositories.AssignmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignmentService {
    private final AssignmentRepository assignmentRepository;
    public List<Assignment> getAllAssignment() {
        return assignmentRepository.findAll();
    }

    public Assignment createAssignment(AssignmentDTO assignmentDTO) {
        Assignment assignment = new Assignment();
        assignment.setNumberOfHour(assignmentDTO.getNumberOfHour());
        return assignmentRepository.save(assignment);
    }
}
