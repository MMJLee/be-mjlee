package dev.mjlee.bemjlee.Project;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "projects")
@CrossOrigin(origins = "http://localhost:8080")
// @CrossOrigin(origins = "https://mjlee.dev", allowedHeaders = "*",
// allowCredentials = "true")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping(path = "/")
    public List<Project> getProjects() {
        return projectService.getProjects();
    }

    @GetMapping(path = "/{id}/")
    public Optional<Project> getProject(@PathVariable("id") Long id) {
        return projectService.getProject(id);
    }

    // cleaner method, but commas aren't url standard
    // @PutMapping(path = "/game/used/{ids}")
    // public void setStatementsUsed(@PathVariable("ids") Long[] ids) {
    // statementService.setStatementsUsed(ids);
    // }
}