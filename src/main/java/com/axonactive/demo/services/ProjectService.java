package com.axonactive.demo.services;

import com.axonactive.demo.dto.ManagedProjectDTO;
import com.axonactive.demo.dto.ProjectDTO;
import com.axonactive.demo.dto.TotalVietHoursDTO;
import com.axonactive.demo.entities.DepartmentLocation;
import com.axonactive.demo.entities.Project;
import com.axonactive.demo.repositories.DepartmentLocationRepository;
import com.axonactive.demo.repositories.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final DepartmentLocationRepository departmentLocationRepository;

    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }

    public List<Project> getProjectByProjectId(Long projectId) {
        return projectRepository.getProjectByProjectId(projectId);
    }

    public Project createProject(ProjectDTO projectDTO) {
        Project project = new Project();
        project.setArea(projectDTO.getArea());
        project.setProjectName(projectDTO.getProjectName());
        return projectRepository.save(project);
    }

    public void deleteProjectByProjectId(Long projectId) {
        projectRepository.deleteById(projectId);
    }

    public Project updateProject(Long projectId, ProjectDTO projectDTO) {
        Optional<Project> project = projectRepository.findById(projectId);
        Project updatedProject = project.get();
        updatedProject.setArea(projectDTO.getArea());
        updatedProject.setProjectName(projectDTO.getProjectName());
        return projectRepository.save(updatedProject);
    }

    public List<ManagedProjectDTO> getAllProjectsManagedByEachDepartment() {
        List<Project> projectList = getAllProject();

        return projectList.stream()
                .map(project -> new ManagedProjectDTO(project.getDepartment().getDeptId(), project))
                .collect(Collectors.toList());
    }

//    public List<TotalVietHoursDTO> getAllProjectsEmployeesAndHoursInVN() {
//        List<Project> projectList = getAllProject();
//
//        if(departmentLocationRepository)
//        Long vnDeptId = departmentLocationRepository.
//
//        //find deptId of Vietnam
//        //find
//    }
}
