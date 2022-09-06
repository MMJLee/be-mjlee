package dev.mjlee.bemjlee.Player;

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
@Table(name = "players")
public class Player {
    @Id
    @SequenceGenerator(name = "players_sequence", sequenceName = "players_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "players_sequence")
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    @CsvBindByName
    private String name;
    @Column(name = "score")
    @CsvBindByName
    private Integer score;

    public Player() {
    }

    public Player(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public Player(Long id, String name, Integer score) {
        this.id = id;
        this.name = name;
        this.score = score;
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

    public Integer getScore() {
        return this.score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Player id(Long id) {
        setId(id);
        return this;
    }

    public Player name(String name) {
        setName(name);
        return this;
    }

    public Player score(Integer score) {
        setScore(score);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Player)) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(id, player.id) && Objects.equals(name, player.name)
                && Objects.equals(score, player.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, score);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", score='" + getScore() + "'" +
                "}";
    }
}