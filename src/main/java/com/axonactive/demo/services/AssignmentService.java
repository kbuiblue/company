package com.axonactive.demo.services;

import com.axonactive.demo.dto.AssignmentDTO;
import com.axonactive.demo.dto.DepartmentDTO;
import com.axonactive.demo.entities.Assignment;
import com.axonactive.demo.entities.Department;
import com.axonactive.demo.repositories.AssignmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Assignment> getAssignmentById(Long id) {
        return assignmentRepository.getAssignmentById(id);
    }

    public void deleteAssignmentById(Long id) {
        assignmentRepository.deleteById(id);
    }

    public Assignment updateAssignment(Long id, AssignmentDTO assignmentDTO) {
        Optional<Assignment> assignment = assignmentRepository.findById(id);
        Assignment updatedAssignment = assignment.get();
        updatedAssignment.setNumberOfHour(assignmentDTO.getNumberOfHour());
        return assignmentRepository.save(updatedAssignment);
    }
}
