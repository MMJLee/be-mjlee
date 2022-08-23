package dev.mjlee.bemjlee.Statement;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StatementRepository extends JpaRepository<Statement, Long> {

    // jpql query needs "FROM *CLASS_NAME*"
    @Query("SELECT s FROM Statement s WHERE s.description = ?1")
    Optional<Statement> findStatementByDescription(String description);

    // native sql query needs "FROM *TABLE_NAME*"
    @Query(value = "(SELECT * FROM statements s WHERE s.truth = true AND s.used = false ORDER BY RANDOM () LIMIT 2) UNION (SELECT * FROM statements s WHERE s.truth = false AND s.used = false ORDER BY RANDOM() LIMIT 1)", nativeQuery = true)
    List<Statement> get2TruthsAndaLie();

    @Modifying
    @Query("UPDATE Statement s SET s.used = true WHERE s.id = ?1")
    void setStatementUsed(Long id);

    @Modifying
    @Query("UPDATE Statement s SET s.used = true WHERE s.id IN (?1, ?2, ?3)")
    void setStatementsUsed(Long id1, Long id2, Long id3);

    @Modifying
    @Query("UPDATE Statement s SET s.used = false")
    void resetAllStatements();
}
