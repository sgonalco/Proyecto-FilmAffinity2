package es.uah.serverFilmAffinity2.service;

import es.uah.serverFilmAffinity2.DAO.IPeliculaDAO;
import es.uah.serverFilmAffinity2.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaServiceImp implements IPeliculaService {

    @Autowired
    IPeliculaDAO peliculaDAO;

    @Override
    public List<Pelicula> buscarTodos() {
        return peliculaDAO.buscarTodos();
    }

    @Override
    public Pelicula buscarPeliculaPorId(Integer id) {
        return peliculaDAO.buscarPeliculaPorId(id);
    }

    @Override
    public List<Pelicula> buscarPeliculaPorTitulo(String titulo) {
        return peliculaDAO.buscarPeliculaPorTitulo(titulo);
    }

    @Override
    public List<Pelicula> buscarPeliculaPorGenero(String genero) {
        return peliculaDAO.buscarPeliculaPorGenero(genero);
    }

    @Override
    public List<Pelicula> buscarPeliculaPorActor(String actor) {
        return peliculaDAO.buscarPeliculaPorActor(actor);
    }

    @Override
    public void guardarPelicula(Pelicula pelicula) {
        peliculaDAO.guardarPelicula(pelicula);
    }

    @Override
    public void actualizarPelicula(Pelicula pelicula) {
        peliculaDAO.actualizarPelicula(pelicula);
    }

    @Override
    public void borrarPelicula(Integer id) {
        peliculaDAO.borrarPelicula(id);
    }

}
