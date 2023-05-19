package com.axonactive.demo.services;

import com.axonactive.demo.dto.RelativesDTO;
import com.axonactive.demo.entities.RelationshipPriority;
import com.axonactive.demo.entities.Relatives;
import com.axonactive.demo.repositories.RelativesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RelativesService {
    private final RelativesRepository relativesRepository;

    public List<Relatives> getAllRelatives() {
        return relativesRepository.findAll();
    }

    public List<Relatives> getRelativesById(Long id) {
        return relativesRepository.getRelativesById(id);
    }

    public Relatives createRelatives(RelativesDTO relativesDTO) {
        Relatives relatives = new Relatives();
        relatives.setFullName(relativesDTO.getFullName());
        relatives.setGender(relativesDTO.getGender());
        relatives.setPhoneNumber(relativesDTO.getPhoneNumber());
        relatives.setRelationship(relativesDTO.getRelationship());
        return relativesRepository.save(relatives);
    }

    public void deleteRelativesById(Long id) {
        relativesRepository.deleteById(id);
    }

    public Relatives updateRelatives(Long id, RelativesDTO relativesDTO) {
        Optional<Relatives> relatives = relativesRepository.findById(id);
        Relatives updatedRelatives = relatives.get();
        updatedRelatives.setFullName(relativesDTO.getFullName());
        updatedRelatives.setGender(relativesDTO.getGender());
        updatedRelatives.setRelationship(relativesDTO.getRelationship());
        updatedRelatives.setPhoneNumber(relativesDTO.getPhoneNumber());
        return relativesRepository.save(updatedRelatives);
    }

    @Transactional
    public List<Relatives> getEmployeeRelatives(String employeeId) {
        List<Relatives> relativesList = getAllRelatives();

        return relativesList.stream()
                .filter(relatives -> relatives.getEmployeeId().getEmployeeId()
                        .equals(employeeId))
                .collect(Collectors.toList());
    }

    @Transactional
    public Optional<Relatives> getEmployeeWithEmergencyContact() {
        List<Relatives> relativesList = getAllRelatives();

        Optional<Relatives> relative = relativesList.stream()
                .filter(rel -> rel.getRelationship().equals(RelationshipPriority.Father))
                .findFirst();

        if (relative.isPresent()) {
            return relative;
        }

        relative = relativesList.stream()
                .filter(rel -> rel.getRelationship().equals(RelationshipPriority.Mother))
                .findFirst();

        if (relative.isPresent()) {
            return relative;
        }

        return relativesList.stream().findFirst();
    }
}
