package dev.buttazzopierluigi.battletohero.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class BattleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int heroId;
    private int hero2Id;
    private int winnerId;

    public BattleEntity() {
    }

    public BattleEntity(int heroId, int hero2Id, int winnerId) {
        this.heroId = heroId;
        this.hero2Id = hero2Id;
        this.winnerId = winnerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHeroId() {
        return heroId;
    }

    public void setHeroId(int heroId) {
        this.heroId = heroId;
    }

    public int getHero2Id() {
        return hero2Id;
    }

    public void setHero2Id(int hero2Id) {
        this.hero2Id = hero2Id;
    }

    public int getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(int winnerId) {
        this.winnerId = winnerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BattleEntity that = (BattleEntity) o;
        return id == that.id && heroId == that.heroId && hero2Id == that.hero2Id && winnerId == that.winnerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, heroId, hero2Id, winnerId);
    }

    @Override
    public String toString() {
        return "BattleEntity{" +
                "id=" + id +
                ", heroId=" + heroId +
                ", hero2Id=" + hero2Id +
                ", winnerId=" + winnerId +
                '}';
    }
}
