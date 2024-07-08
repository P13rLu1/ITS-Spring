package dev.buttazzopierluigi.battletohero.service;

import dev.buttazzopierluigi.battletohero.entity.HeroEntity;

import java.util.List;

public interface HeroService {

    int addHero(HeroEntity hero);

    List<HeroEntity> getHeroes();

    HeroEntity getHeroById(int id);

    void updateHero(HeroEntity hero, int id);

    void deleteHero(int id);
}
