package com.axonactive.demo.services;

import com.axonactive.demo.dto.ProjectDTO;
import com.axonactive.demo.entities.Project;
import com.axonactive.demo.repositories.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }

    public Project createProject(ProjectDTO projectDTO) {
        Project project = new Project();
        project.setArea(projectDTO.getArea());
        project.setProjectName(projectDTO.getProjectName());
        return projectRepository.save(project);
    }
}
