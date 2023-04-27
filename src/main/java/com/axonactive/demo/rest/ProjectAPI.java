package com.axonactive.demo.rest;

import com.axonactive.demo.dto.ProjectDTO;
import com.axonactive.demo.entities.Project;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/projects")
public interface ProjectAPI {
    @GetMapping
    ResponseEntity<List<Project>> getAllProject();

    @GetMapping("/project-ids")
    ResponseEntity<List<Project>> getProjectByProjectId(@RequestParam("projectId") Long projectId);

    @PostMapping
    ResponseEntity<Project> createProject(@RequestBody ProjectDTO projectDTO);

    @DeleteMapping
    ResponseEntity<Void> deleteProjectByProjectId(@RequestParam("projectId") Long projectId);

    @PutMapping("/{projectId}")
    ResponseEntity<Project> updateProject(@PathVariable("projectId") Long projectId,
                                          @RequestBody ProjectDTO projectDTO);
}
