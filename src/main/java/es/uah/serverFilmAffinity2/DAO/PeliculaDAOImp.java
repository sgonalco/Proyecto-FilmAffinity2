package es.uah.serverFilmAffinity2.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import es.uah.serverFilmAffinity2.model.Pelicula;

@Repository
public class PeliculaDAOImp implements IPeliculaDAO {

    @Autowired
    IPeliculaJPA peliculaJPA;

    public PeliculaDAOImp(IPeliculaJPA peliculaJPA) {
        this.peliculaJPA = peliculaJPA;
    }

    @Override
    public List<Pelicula> buscarTodos() {return peliculaJPA.findAll();}

    @Override
    public Pelicula buscarPeliculaPorId(Integer idPelicula) {
        Optional<Pelicula> optional =  peliculaJPA.findById(idPelicula);
        return optional.orElse(null);
    }

    @Override
    public List<Pelicula> buscarPeliculaPorTitulo(String titulo) {
        return peliculaJPA.findByTitulo(titulo);
    }

    @Override
    public List<Pelicula> buscarPeliculaPorGenero(String genero) {
        return peliculaJPA.findByGenero(genero);
    }

    @Override
    public List<Pelicula> buscarPeliculaPorActor(String nombreActor) {
        return peliculaJPA.findByActores_Nombre(nombreActor);
    }

    @Override
    public void guardarPelicula(Pelicula pelicula) {
        peliculaJPA.save(pelicula);
    }

    @Override
    public void borrarPelicula(Integer idPelicula) {
        peliculaJPA.deleteById(idPelicula);
    }

    @Override
    public void actualizarPelicula(Pelicula pelicula) {
        peliculaJPA.save(pelicula);
    }
}
