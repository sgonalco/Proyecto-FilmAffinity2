package es.uah.serverFilmAffinity2.service;

import java.util.List;
import es.uah.serverFilmAffinity2.model.Pelicula;

public interface IPeliculaService {
    List<Pelicula> buscarTodos();

    Pelicula buscarPeliculaPorId(Integer idPelicula);

    List<Pelicula> buscarPeliculaPorTitulo(String titulo);

    List<Pelicula> buscarPeliculaPorGenero(String genero);

    List<Pelicula> buscarPeliculaPorActor(String nombreActor );

    void guardarPelicula(Pelicula pelicula);

    void borrarPelicula(Integer idPelicula);

    void actualizarPelicula(Pelicula pelicula);
}
