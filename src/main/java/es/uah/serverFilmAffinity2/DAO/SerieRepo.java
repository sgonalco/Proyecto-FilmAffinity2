package es.uah.serverFilmAffinity2.DAO;

import es.uah.serverFilmAffinity2.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SerieRepo extends JpaRepository<Serie, Integer> {
}
