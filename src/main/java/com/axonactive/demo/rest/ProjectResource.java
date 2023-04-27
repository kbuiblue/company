package com.axonactive.demo.rest;

import com.axonactive.demo.dto.ProjectDTO;
import com.axonactive.demo.entities.Project;
import com.axonactive.demo.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProjectResource implements ProjectAPI {
    private final ProjectService projectService;
    @Override
    public ResponseEntity<List<Project>> getAllProject() {
        return ResponseEntity.ok(projectService.getAllProject());
    }

    @Override
    public ResponseEntity<Project> createProject(ProjectDTO projectDTO) {
        Project project = projectService.createProject(projectDTO);
        return ResponseEntity.created(URI.create("/api/projects" + project.getProjectId())).body(project);
    }

    @Override
    public ResponseEntity<List<Project>> getProjectByProjectId(Long projectId) {
        return ResponseEntity.ok(projectService.getProjectByProjectId(projectId));
    }


}
