package com.axonactive.demo.repositories;

import com.axonactive.demo.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> getProjectByProjectId(Long projectId);
}
