package dev.mjlee.bemjlee.Project;

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
@Table(name = "projects")
public class Project {
    @Id
    @SequenceGenerator(name = "projects_sequence", sequenceName = "projects_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projects_sequence")
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    @CsvBindByName
    private String name;
    @Column(name = "tech")
    @CsvBindByName
    private String[] tech;
    @Column(columnDefinition = "TEXT", length = 2048, name = "comment")
    @CsvBindByName
    private String comment;
    @Column(columnDefinition = "TEXT", name = "view")
    @CsvBindByName
    private String view;

    public Project() {
    }

    public Project(String name, String[] tech, String comment, String view) {
        this.name = name;
        this.tech = tech;
        this.comment = comment;
        this.view = view;
    }

    public Project(Long id, String name, String[] tech, String comment, String view) {
        this.id = id;
        this.name = name;
        this.tech = tech;
        this.comment = comment;
        this.view = view;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getTech() {
        return this.tech;
    }

    public void setTech(String[] tech) {
        this.tech = tech;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getView() {
        return this.view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public Project id(Long id) {
        setId(id);
        return this;
    }

    public Project name(String name) {
        setName(name);
        return this;
    }

    public Project tech(String[] tech) {
        setTech(tech);
        return this;
    }

    public Project comment(String comment) {
        setComment(comment);
        return this;
    }

    public Project view(String view) {
        setView(view);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Project)) {
            return false;
        }
        Project project = (Project) o;
        return Objects.equals(id, project.id) && Objects.equals(name, project.name)
                && Objects.equals(tech, project.tech) && Objects.equals(comment, project.comment)
                && Objects.equals(view, project.view);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, tech, comment, view);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", tech='" + getTech() + "'" +
                ", comment='" + getComment() + "'" +
                ", view='" + getView() + "'" +
                "}";
    }

}
