package es.uah.serverFilmAffinity2.DAO;

import es.uah.serverFilmAffinity2.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IActorJPA extends JpaRepository<Actor, Integer>{
    List<Actor> findByNombre(String nombre);
}
