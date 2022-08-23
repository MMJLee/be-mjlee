package dev.mjlee.bemjlee.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class StatementService {

    private final StatementRepository statementRepository;

    public StatementService(StatementRepository statementRepository) {
        this.statementRepository = statementRepository;
    }

    public List<Statement> getStatements() {
        return statementRepository.findAll();
    }

    public Optional<Statement> getStatement(Long statementId) {
        if (!statementRepository.existsById(statementId))
            throw new IllegalStateException("Statement " + statementId + " not found");
        else
            return statementRepository.findById(statementId);

    }

    public List<Statement> get2TruthsAndaLie() {
        List<Statement> response = statementRepository.get2TruthsAndaLie();
        if (response.size() < 3)
            return new ArrayList<Statement>() {
            };
        return response;
    }

    public void addStatement(Statement statement) {
        System.out.println(statement);
        statementRepository.save(statement);
    }

    public void deleteStatement(Long statementId) {
        statementRepository.findById(statementId);
        if (!statementRepository.existsById(statementId)) {
            throw new IllegalStateException("Statement " + statementId + " not found");
        } else {
            statementRepository.deleteById(statementId);
        }
    }

    @Transactional
    public void updateStatement(Long statementId, String description, boolean truth, String backstory, boolean used) {
        Statement statement = statementRepository.findById(statementId)
                .orElseThrow(() -> new IllegalStateException("Statement with ID " + statementId + " not found"));
        if (description != null && description.length() > 0
                && !Objects.equals(statement.getDescription(), description))
            statement.setDescription(description);
        statement.setTruth(truth);
        statement.setBackstory(backstory);
        statement.setUsed(used);
    }

    @Transactional
    public void setStatementUsed(Long id) {
        statementRepository.setStatementUsed(id);
    }

    // @Transactional
    // public void setStatementsUsed(Long[] ids) {
    // statementRepository.setStatementsUsed(ids);
    // }

    @Transactional
    public void setStatementsUsed(Long id1, Long id2, Long id3) {
        statementRepository.setStatementsUsed(id1, id2, id3);
    }

    @Transactional
    public void resetAllStatements() {
        statementRepository.resetAllStatements();
    }
}
