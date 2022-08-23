package dev.mjlee.bemjlee.Statement;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.opencsv.bean.CsvBindByName;

@Entity
@Table(name = "statements")
public class Statement {
    @Id
    @SequenceGenerator(name = "statements_sequence", sequenceName = "statements_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "statements_sequence")
    @Column(name = "id")
    private Long id;
    @Column(columnDefinition = "TEXT", length = 2048, name = "description")
    @CsvBindByName
    private String description;
    @Column(name = "truth")
    @CsvBindByName
    private boolean truth;
    @Column(columnDefinition = "TEXT", length = 2048, name = "backstory")
    @CsvBindByName
    private String backstory;
    @Column(name = "used")
    @CsvBindByName
    private boolean used;

    public Statement() {
    }

    public Statement(Long id, String description, boolean truth, String backstory) {
        this.id = id;
        this.description = description;
        this.truth = truth;
        this.backstory = backstory;
        this.used = false;
    }

    public Statement(String description, boolean truth, String backstory) {
        this.description = description;
        this.truth = truth;
        this.backstory = backstory;
        this.used = false;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isTruth() {
        return this.truth;
    }

    public boolean getTruth() {
        return this.truth;
    }

    public void setTruth(boolean truth) {
        this.truth = truth;
    }

    public String getBackstory() {
        return this.backstory;
    }

    public void setBackstory(String backstory) {
        this.backstory = backstory;
    }

    public boolean isUsed() {
        return this.used;
    }

    public boolean getUsed() {
        return this.used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public Statement id(Long id) {
        setId(id);
        return this;
    }

    public Statement description(String description) {
        setDescription(description);
        return this;
    }

    public Statement truth(boolean truth) {
        setTruth(truth);
        return this;
    }

    public Statement backstory(String backstory) {
        setBackstory(backstory);
        return this;
    }

    public Statement used(boolean used) {
        setUsed(used);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Statement)) {
            return false;
        }
        Statement statement = (Statement) o;
        return Objects.equals(id, statement.id) && Objects.equals(description, statement.description)
                && truth == statement.truth && Objects.equals(backstory, statement.backstory) && used == statement.used;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, truth, backstory, used);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", description='" + getDescription() + "'" +
                ", truth='" + isTruth() + "'" +
                ", backstory='" + getBackstory() + "'" +
                ", used='" + isUsed() + "'" +
                "}";
    }
}
