package es.uah.serverFilmAffinity2.service;

import es.uah.serverFilmAffinity2.DAO.ActorRepo;
import es.uah.serverFilmAffinity2.DAO.SerieRepo;
import es.uah.serverFilmAffinity2.DTO.SerieDTO;
import es.uah.serverFilmAffinity2.exceptions.ConflictException;
import es.uah.serverFilmAffinity2.exceptions.ResourceNotFoundException;
import es.uah.serverFilmAffinity2.model.Actor;
import es.uah.serverFilmAffinity2.model.Serie;
import es.uah.serverFilmAffinity2.model.Temporada;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {

    @Autowired
    private SerieRepo serieRepo;

    @Autowired
    private ActorRepo actorRepo;

    public List<SerieDTO> getlAll(){
        List<Serie> series = serieRepo.findAll();
        if(series.isEmpty()){
            throw new ResourceNotFoundException(
                    "Lista de series vacia"
            );
        }
        return series.stream().map(
                s -> new SerieDTO(
                        s.getTitulo(),
                        s.getAnnoEstreno(),
                        List.of(),//s.getActores(),
                        List.of(),//s.getDirectors(),
                        List.of(),//s.getTemporadas(),
                        s.getGeneros()))
                .toList();
    }

    public SerieDTO findById(Integer id){
        Serie serie = serieRepo.findById(id).
                orElseThrow(() ->  new ResourceNotFoundException(
                        "serie con id: " + id + " no encontrado")
                );
        return new SerieDTO(
                serie.getTitulo(),
                serie.getAnnoEstreno(),
                List.of(),//serie.getActores(),
                List.of(),//serie.getDirectores(),
                List.of(),//serie.getTemporadas(),
                serie.getGeneros()
        );
    }

    public SerieDTO findByTitulo(String titulo){
        Serie serie = serieRepo.findByTitulo(titulo)
                .orElseThrow(() ->  new ResourceNotFoundException(
                        "Serie con titulo: " + titulo + " no encontrado"
                ));
        return new SerieDTO(
                serie.getTitulo(),
                serie.getAnnoEstreno(),
                List.of(),//serie.getActores(),
                List.of(),//serie.getDirectores(),
                List.of(),//serie.getTemporadas(),
                serie.getGeneros()
        );
    }

    public boolean checkActor(String titulo, String nombreActor){
        // tiene que ser con booleano. cambiar nombre (check).
        boolean flagActua = false;
        Actor actor = actorRepo.findByNombre(nombreActor).
                orElseThrow(() ->  new ResourceNotFoundException(
                        "Actor con nombre: " + nombreActor + " no encontrado"
                ));
        Serie serie = serieRepo.findByTitulo(titulo)
                .orElseThrow(() ->  new ResourceNotFoundException(
                        "Serie con titulo: " +  titulo + " no encontrado"
                ));
        List<Actor> repartoSerie = serie.getActores();
        if(repartoSerie.contains(actor)){
            flagActua = true;
        }
        return flagActua;
    }

    @Transactional
    public SerieDTO save(SerieDTO seriedto){
        if(!serieRepo.findByTitulo(seriedto.getTitulo()).isEmpty()){
            throw new ConflictException(
                    "Ya existe una serie con el mismo titulo"
            );
        }
        Serie serie = new Serie();
        serie.setTitulo(seriedto.getTitulo());
        serie.setAnnoEstreno(seriedto.getAnnoEstreno());
        serie.setActores(seriedto.getActores());
        serie.setDirectors(seriedto.getDirectores());
        serie.setTemporadas(seriedto.getTemporadas());
        serie.setGeneros(seriedto.getGeneros());
        Serie savedSerie = serieRepo.save(serie);

        return new  SerieDTO(
                savedSerie.getTitulo(),
                savedSerie.getAnnoEstreno(),
                List.of(),//savedSerie.getActores(),
                List.of(),//savedSerie.getDirectors(),
                List.of(),//savedSerie.getTemporadas(),
                savedSerie.getGeneros()
        );
    }

    public Integer contarEpisodios(String titulo){
        // devuelve valores, nunca mensajes. INTEGER
        int contadorEps = 0;
        Serie serie = serieRepo.findByTitulo(titulo)
                .orElseThrow(() ->  new ResourceNotFoundException(
                        "Serie no encontrada"
                ));
        List<Temporada> temporadas = serie.getTemporadas();
        for(Temporada temporada : temporadas){
            contadorEps += temporada.getNumEpisodios();
        }
        return contadorEps;
    }

    @Transactional
    public SerieDTO update(Integer id, SerieDTO seriedto){
        Serie existing = serieRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                    "Serie con id: " + id + " no encontrado"
                ));
        existing.setTitulo(seriedto.getTitulo());
        existing.setAnnoEstreno(seriedto.getAnnoEstreno());
        existing.setActores(List.of());
        existing.setDirectors(List.of());
        existing.setTemporadas(List.of());
        existing.setGeneros(List.of());
        Serie updatedSerie = serieRepo.save(existing);

        return new SerieDTO(
                updatedSerie.getTitulo(),
                updatedSerie.getAnnoEstreno(),
                List.of(),//updatedSerie.getActores(),
                List.of(),//updatedSerie.getDirectors(),
                List.of(),//updatedSerie.getTemporadas(),
                updatedSerie.getGeneros()
        );
    }

    @Transactional
    public void delete(Integer id){
        try{
            if(id == null){
                throw new RuntimeException(
                        "id del objeto no puede ser nulo"
                );
            }
            Serie serie = serieRepo.findById(id).
                    orElseThrow(() -> new RuntimeException(
                            "Serie no encontrado"
                    ));
            serieRepo.delete(serie);
        }catch(Exception e){
            throw new RuntimeException(
                    e.getMessage()
            );
        }
    }
}
