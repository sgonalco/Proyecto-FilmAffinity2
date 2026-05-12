package es.uah.serverFilmAffinity2.DAO;

import es.uah.serverFilmAffinity2.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IPeliculaJPA extends JpaRepository<Pelicula, Integer> {
    List<Pelicula> findByTitulo(String titulo);

    List<Pelicula> findByActores_Nombre(String nombre);

    List<Pelicula> findByGenero(String genero);
}
