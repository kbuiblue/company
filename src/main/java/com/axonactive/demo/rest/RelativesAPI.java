package com.axonactive.demo.rest;

import com.axonactive.demo.dto.DepartmentDTO;
import com.axonactive.demo.dto.RelativesDTO;
import com.axonactive.demo.entities.Department;
import com.axonactive.demo.entities.Relatives;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/relatives")
public interface RelativesAPI {
    @GetMapping
    ResponseEntity<List<Relatives>> getAllRelatives();

    @GetMapping("/ids")
    ResponseEntity<List<Relatives>> getRelativesById(@RequestParam("id") Long id);

    @PostMapping
    ResponseEntity<Relatives> createRelatives(@RequestBody RelativesDTO relativesDTO);

    @DeleteMapping
    ResponseEntity<Void> deleteRelativesById(@RequestParam("id") Long id);

    @PutMapping("/{id}")
    ResponseEntity<Relatives> updateRelatives(@PathVariable("id") Long id,
                                                @RequestBody RelativesDTO relativesDTO);
}
