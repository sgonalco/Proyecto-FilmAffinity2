package es.uah.serverFilmAffinity2.DAO;

import es.uah.serverFilmAffinity2.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActorRepo extends JpaRepository<Actor, Integer> {

    Optional<Actor> findByNombre(String nombre);

}
