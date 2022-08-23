package dev.mjlee.bemjlee.Statement;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "statements")
@CrossOrigin(origins = "http://localhost:8080")
// @CrossOrigin(origins = "https://mjlee.dev", allowedHeaders = "*",
// allowCredentials = "true")
public class StatementController {

    private final StatementService statementService;

    public StatementController(StatementService statementService) {
        this.statementService = statementService;
    }

    @GetMapping(path = "/")
    public List<Statement> getStatements() {
        return statementService.getStatements();
    }

    @GetMapping(path = "/{id}")
    public Optional<Statement> getStatement(@PathVariable("id") Long id) {
        return statementService.getStatement(id);
    }

    // cleaner method, but commas aren't url standard
    // @PutMapping(path = "/game/used/{ids}")
    // public void setStatementsUsed(@PathVariable("ids") Long[] ids) {
    // statementService.setStatementsUsed(ids);
    // }

    @PutMapping(path = "/game/{id1}-{id2}-{id3}/")
    public void setStatementsUsed(@PathVariable("id1") Long id1, @PathVariable("id2") Long id2,
            @PathVariable("id3") Long id3) {
        statementService.setStatementsUsed(id1, id2, id3);
    }

    @PutMapping(path = "/game/reset/")
    public void resetAllStatements() {
        statementService.resetAllStatements();
    }

    @GetMapping(path = "/game/")
    public List<Statement> get2TruthsAndaLie() {
        return statementService.get2TruthsAndaLie();
    }

    @PostMapping(path = "/")
    public void registerStatement(@RequestBody Statement statement) {
        statementService.addStatement(statement);
    }

    @DeleteMapping(path = "/statement/{id}/")
    public void deleteStatement(@PathVariable("id") Long id) {
        statementService.deleteStatement(id);
    }

    @PutMapping(path = "/statement/{id}/")
    public void updateStatement(@PathVariable("id") Long id,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) boolean truth,
            @RequestParam(required = false) String backstory,
            @RequestParam(required = false) boolean used) {
        statementService.updateStatement(id, description, truth, backstory, used);
    }

}