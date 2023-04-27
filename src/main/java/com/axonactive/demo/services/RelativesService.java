package com.axonactive.demo.services;

import com.axonactive.demo.dto.ProjectDTO;
import com.axonactive.demo.dto.RelativesDTO;
import com.axonactive.demo.entities.Project;
import com.axonactive.demo.entities.Relatives;
import com.axonactive.demo.repositories.RelativesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
}
