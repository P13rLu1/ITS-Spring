package dev.buttazzopierluigi.battletohero.service.impl;

import dev.buttazzopierluigi.battletohero.entity.BattleEntity;
import dev.buttazzopierluigi.battletohero.entity.HeroEntity;
import dev.buttazzopierluigi.battletohero.exception.HeroException;
import dev.buttazzopierluigi.battletohero.repository.BattleRepository;
import dev.buttazzopierluigi.battletohero.repository.HeroRepository;
import dev.buttazzopierluigi.battletohero.service.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BattleServiceImpl implements BattleService {

    @Autowired
    private BattleRepository battleRepository;
    @Autowired
    private HeroRepository heroRepository;

    @Override
    public int startBattle(int heroId, int heroId2, double difficulty) {
        HeroEntity hero1 = heroRepository.findById(heroId).orElse(null);
        HeroEntity hero2 = heroRepository.findById(heroId2).orElse(null);

        if (hero1 == null || hero2 == null) {
            throw new HeroException("Eroe non trovato");
        }

        // formula per il calcolo del danno inflitto che tiene conto della forza, della difesa e del livello dei due eroi
        double hero1Damage = hero1.getStrength() * (1 - (double) hero2.getDefense() / 100) * (1 + (double) hero1.getLevel() / 10) * difficulty;
        double hero2Damage = hero2.getStrength() * (1 - (double) hero1.getDefense() / 100) * (1 + (double) hero2.getLevel() / 10) * difficulty;

        return simulateBattle(heroId, heroId2, hero1.getHealth(), hero2.getHealth(), hero1Damage, hero2Damage);
    }

    // funzione per simulare la battaglia tra due eroi
    private int simulateBattle(int heroId, int heroId2, int hero1Health, int hero2Health, double hero1Damage, double hero2Damage) {
        // ciclo che simula la battaglia fino a quando uno dei due eroi non ha più punti vita
        while (hero1Health > 0 && hero2Health > 0) {
            hero2Health -= (int) hero1Damage;
            hero1Health -= (int) hero2Damage;
        }

        // se l'eroe 1 ha ancora punti vita, allora è il vincitore altrimenti vince l'eroe 2
        int winner = hero1Health > 0 ? heroId : heroId2;
        addToHistory(heroId, heroId2, winner);
        return winner;
    }

    // funzione per aggiungere la battaglia appena simulata alla storia (DB)
    private void addToHistory(int heroId1, int heroId2, int winner) {
        BattleEntity battle = new BattleEntity(heroId1, heroId2, winner);
        battleRepository.save(battle);
    }
}
