package dev.buttazzopierluigi.battletohero.entity;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
public class HeroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private RaceEnum race;
    private int strength;
    private int defense;
    private int health;
    private int level;

    public HeroEntity() {
    }

    public HeroEntity(String name, RaceEnum race, int strength, int defense, int health, int level) {
        this.name = name;
        this.race = race;
        this.strength = strength;
        this.defense = defense;
        this.health = health;
        this.level = level;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RaceEnum getRace() {
        return race;
    }

    public void setRace(RaceEnum race) {
        this.race = race;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeroEntity that = (HeroEntity) o;
        return id == that.id && strength == that.strength && defense == that.defense && health == that.health && level == that.level && Objects.equals(name, that.name) && Objects.equals(race, that.race);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, race, strength, defense, health, level);
    }

    @Override
    public String toString() {
        return "heroEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", race=" + race +
                ", strength=" + strength +
                ", defense=" + defense +
                ", health=" + health +
                ", level=" + level +
                '}';
    }
}
