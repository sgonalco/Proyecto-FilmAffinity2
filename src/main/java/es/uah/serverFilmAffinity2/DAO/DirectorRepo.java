package es.uah.serverFilmAffinity2.DAO;

import es.uah.serverFilmAffinity2.model.Director;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

@Repository
public interface DirectorRepo extends JpaRepository<Director, Integer>{

    Optional<Director> findByNombre(String nombre);
}
