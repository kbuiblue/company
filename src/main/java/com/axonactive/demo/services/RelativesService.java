package com.axonactive.demo.services;

import com.axonactive.demo.dto.RelativesDTO;
import com.axonactive.demo.entities.Relatives;
import com.axonactive.demo.repositories.RelativesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RelativesService {
    private final RelativesRepository relativesRepository;

    public List<Relatives> getAllRelatives() {
        return relativesRepository.findAll();
    }

    public Relatives createRelatives(RelativesDTO relativesDTO) {
        Relatives relatives = new Relatives();
        relatives.setFullName(relativesDTO.getFullName());
        relatives.setGender(relativesDTO.getGender());
        relatives.setPhoneNumber(relativesDTO.getPhoneNumber());
        relatives.setRelationship(relativesDTO.getRelationship());
        return relativesRepository.save(relatives);
    }
}
