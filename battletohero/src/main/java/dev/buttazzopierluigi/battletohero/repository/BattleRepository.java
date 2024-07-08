package dev.buttazzopierluigi.battletohero.repository;

import dev.buttazzopierluigi.battletohero.entity.BattleEntity;
import org.springframework.data.repository.CrudRepository;

public interface BattleRepository extends CrudRepository<BattleEntity, String> {
}
