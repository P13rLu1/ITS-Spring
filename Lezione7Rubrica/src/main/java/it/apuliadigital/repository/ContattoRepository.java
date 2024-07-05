package it.apuliadigital.repository;

import it.apuliadigital.entity.ContattoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContattoRepository extends CrudRepository<ContattoEntity, String> {

    List<ContattoEntity> searchByNomeAndCognome(@Param("nome") String nome, @Param("cognome") String cognome);

    List<ContattoEntity> searchByNome(@Param("nome") String nome);

    List<ContattoEntity> searchByCognome(@Param("cognome") String cognome);
}
