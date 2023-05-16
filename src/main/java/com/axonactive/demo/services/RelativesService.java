package com.axonactive.demo.services;

import com.axonactive.demo.dto.RelativesDTO;
import com.axonactive.demo.entities.Relatives;
import com.axonactive.demo.repositories.RelativesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
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

    public List<Relatives> getEmployeeRelatives(String employeeId) {
        List<Relatives> relativesList = getAllRelatives();

        List<Relatives> filteredRelatives = relativesList.stream()
                .filter(relatives -> relatives.getEmployeeId().getEmployeeId()
                .equals(employeeId))
                .collect(Collectors.toList());

        return filteredRelatives;
    }

    public Relatives getEmployeeWithEmergencyContact() {
        List<Relatives> relativesList = getAllRelatives();

        List<Relatives> filteredFathers = relativesList.stream()
                .filter(relatives -> relatives.getRelationship().equals("father"))
                .collect(Collectors.toList());

        List<Relatives> filteredMothers = relativesList.stream()
                .filter(relatives -> relatives.getRelationship().equals("mother"))
                .collect(Collectors.toList());

        Map<String, List<Relatives>> employeeRelativesMap = relativesList.stream()
                .collect(Collectors.groupingBy(relatives -> relatives.getEmployeeId().getEmployeeId()));

        Relatives relative = null;
        for (String employeeId : employeeRelativesMap.keySet()) {
            List<Relatives> relatives = employeeRelativesMap.get(employeeId);
            if (relatives.stream().anyMatch(filteredFathers::contains)) {
                relative = relatives.stream()
                        .filter(rel -> rel.getRelationship().equals("father"))
                        .findFirst()
                        .get();
            } else if (relatives.stream().anyMatch(filteredMothers::contains)) {
                relative = relatives.stream()
                        .filter(rel -> rel.getRelationship().equals("mother"))
                        .findFirst()
                        .get();
            } else {
                relative = relatives.get(0);
            }
        }
        return relative;
    }
}
