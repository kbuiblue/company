package com.axonactive.demo.rest;

import com.axonactive.demo.dto.RelativesDTO;
import com.axonactive.demo.entities.Relatives;
import com.axonactive.demo.services.RelativesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RelativesResource implements RelativesAPI{
    private final RelativesService relativesService;

    @Override
    public ResponseEntity<List<Relatives>> getAllRelatives() {
        return ResponseEntity.ok(relativesService.getAllRelatives());
    }

    @Override
    public ResponseEntity<List<Relatives>> getRelativesById(Long id) {
        return ResponseEntity.ok(relativesService.getRelativesById(id));
    }

    @Override
    public ResponseEntity<Relatives> createRelatives(RelativesDTO relativesDTO) {
        Relatives relatives = relativesService.createRelatives(relativesDTO);
        return ResponseEntity.created(URI.create("/api/relatives" + relatives.getId())).body(relatives);
    }


}
