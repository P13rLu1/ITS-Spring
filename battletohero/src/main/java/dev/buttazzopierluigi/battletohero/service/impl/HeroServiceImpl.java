package dev.buttazzopierluigi.battletohero.service.impl;

import dev.buttazzopierluigi.battletohero.entity.HeroEntity;
import dev.buttazzopierluigi.battletohero.exception.HeroException;
import dev.buttazzopierluigi.battletohero.repository.HeroRepository;
import dev.buttazzopierluigi.battletohero.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroServiceImpl implements HeroService {

    // mi inietto il repository
    @Autowired
    private HeroRepository heroRepository;


    // implemento il metodo per aggiungere un eroe
    @Override
    public int addHero(HeroEntity hero) {
        heroRepository.save(hero);
        return hero.getId();
    }


    // implemento il metodo per ottenere tutti gli eroi
    @Override
    public List<HeroEntity> getHeroes() {
        return (List<HeroEntity>) heroRepository.findAll();
    }

    // implemento il metodo per ottenere un eroe per id
    @Override
    public HeroEntity getHeroById(int id) {
        if (heroRepository.findById(id).isEmpty()) {
            throw new HeroException("Eroe non trovato");
        }
        return heroRepository.findById(id).orElse(null);
    }

    // implemento il metodo per aggiornare un eroe
    @Override
    public void updateHero(HeroEntity hero, int id) {
        HeroEntity heroEntity = heroRepository.findById(id).orElse(null);
        if (heroEntity == null) {
            throw new HeroException("Eroe non trovato");
        } else {
            heroEntity.setName(hero.getName());
            heroEntity.setRace(hero.getRace());
            heroEntity.setHealth(hero.getHealth());
            heroEntity.setStrength(hero.getStrength());
            heroEntity.setDefense(hero.getDefense());
            heroEntity.setLevel(hero.getLevel());
            heroRepository.save(heroEntity);
        }
    }

    // implemento il metodo per eliminare un eroe per id
    @Override
    public void deleteHero(int id) {
        if (heroRepository.findById(id).isEmpty()) {
            throw new HeroException("Eroe non trovato");
        }
        heroRepository.deleteById(id);
    }
}
