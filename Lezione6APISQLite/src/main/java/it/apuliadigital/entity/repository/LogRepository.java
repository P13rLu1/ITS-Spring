package it.apuliadigital.entity.repository;

import it.apuliadigital.entity.LogEntity;
import org.springframework.data.repository.CrudRepository;

public interface LogRepository extends CrudRepository<LogEntity, String>{

    // questa interfaccia estende CrudRepository, che è un'interfaccia di Spring Data JPA che fornisce metodi CRUD standard
}
