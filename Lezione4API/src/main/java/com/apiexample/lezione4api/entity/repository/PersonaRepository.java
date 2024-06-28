package com.apiexample.lezione4api.entity.repository;

import com.apiexample.lezione4api.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {

    //metodi
}
