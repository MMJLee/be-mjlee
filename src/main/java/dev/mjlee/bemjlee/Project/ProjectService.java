package dev.mjlee.bemjlee.Project;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProject(Long projectId) {
        if (!projectRepository.existsById(projectId))
            throw new IllegalStateException("Project " + projectId + " not found");
        else
            return projectRepository.findById(projectId);

    }

    public void addProject(Project project) {
        System.out.println(project);
        projectRepository.save(project);
    }

    public void deleteProject(Long projectId) {
        projectRepository.findById(projectId);
        if (!projectRepository.existsById(projectId)) {
            throw new IllegalStateException("Project " + projectId + " not found");
        } else {
            projectRepository.deleteById(projectId);
        }
    }
}
