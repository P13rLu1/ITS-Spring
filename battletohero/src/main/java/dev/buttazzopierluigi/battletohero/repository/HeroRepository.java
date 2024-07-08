package dev.buttazzopierluigi.battletohero.repository;

import dev.buttazzopierluigi.battletohero.entity.HeroEntity;
import org.springframework.data.repository.CrudRepository;

public interface HeroRepository extends CrudRepository<HeroEntity, Integer> {
}