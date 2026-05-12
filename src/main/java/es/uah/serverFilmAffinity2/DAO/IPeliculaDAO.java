package es.uah.serverFilmAffinity2.DAO;

import es.uah.serverFilmAffinity2.model.Pelicula;
import java.util.List;

public interface IPeliculaDAO {
    List<Pelicula> buscarTodos();

    Pelicula buscarPeliculaPorId(Integer idPelicula);

    List<Pelicula> buscarPeliculaPorTitulo(String titulo);

    List<Pelicula> buscarPeliculaPorGenero(String genero);

    List<Pelicula> buscarPeliculaPorActor(String nombreActor );

    void guardarPelicula(Pelicula pelicula);

    void borrarPelicula(Integer idPelicula);

    void actualizarPelicula(Pelicula pelicula);
}
