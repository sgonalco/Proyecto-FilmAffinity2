package es.uah.serverFilmAffinity2.DAO;

import es.uah.serverFilmAffinity2.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SerieRepo extends JpaRepository<Serie, Integer> {
    Optional<Serie> findByTitulo(String titulo);

}
