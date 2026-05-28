package es.uah.serverFilmAffinity2.DAO;

import es.uah.serverFilmAffinity2.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ActorRepo extends JpaRepository<Actor, Integer> {

    Optional<Actor> findByNombre(String nombre);

}
