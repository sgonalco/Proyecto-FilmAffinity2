package es.uah.serverFilmAffinity2.service;

import es.uah.serverFilmAffinity2.DAO.ActorRepo;
import es.uah.serverFilmAffinity2.DAO.SerieRepo;
import es.uah.serverFilmAffinity2.DTO.SerieDTO;
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
        try{ // PRUEBA: si series vacia devolver excepcion personalizadas
            List<Serie> series = serieRepo.findAll();
            if(series.isEmpty()){
                throw new RuntimeException(
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
        }catch(Exception e){
            throw new RuntimeException(
                    e.getMessage()
            );
        }
    }

    public SerieDTO findById(Integer id){
        try{
            if(id == null){
                throw new RuntimeException(
                        "Id de entrada no puede ser nulo"
                );
            }
            Serie serie = serieRepo.findById(id).
                    orElseThrow(() ->  new RuntimeException(
                            "Serie no encontrado")
                    );
            return new SerieDTO(
                    serie.getTitulo(),
                    serie.getAnnoEstreno(),
                    List.of(),//serie.getActores(),
                    List.of(),//serie.getDirectores(),
                    List.of(),//serie.getTemporadas(),
                    serie.getGeneros()
            );
        }catch(Exception e){
            throw new RuntimeException(
                    e.getMessage()
            );
        }
    }

    public SerieDTO findByTitulo(String titulo){
        try{
            if(titulo == null || titulo.isBlank()){
                throw new RuntimeException(
                        "Serie no puede estar en blanco"
                );
            }
            Serie serie = serieRepo.findByTitulo(titulo)
                    .orElseThrow(() ->  new RuntimeException(
                            "Serie no encontrado"
                    ));
            SerieDTO serieDTO = new SerieDTO(
                    serie.getTitulo(),
                    serie.getAnnoEstreno(),
                    List.of(),//serie.getActores(),
                    List.of(),//serie.getDirectores(),
                    List.of(),//serie.getTemporadas(),
                    serie.getGeneros()
            );
            return serieDTO;
        }catch(Exception e){
            throw new RuntimeException(
                    e.getMessage()
            );
        }
    }

    public boolean checkActor(String titulo, String nombreActor){
        try{
            // tiene que ser con booleano. cambiar nombre (check).
            boolean flagActua = false;
            if(nombreActor.isBlank()){
                throw new RuntimeException(
                        "Nombre de actor no puede ser vacio"
                );
            }
            Actor actor = actorRepo.findByNombre(nombreActor).
                    orElseThrow(() ->  new RuntimeException(
                            "Actor no encontrado"
                    ));
            Serie serie = serieRepo.findByTitulo(titulo)
                    .orElseThrow(() ->  new RuntimeException(
                            "Serie no encontrada"
                    ));
            List<Actor> repartoSerie = serie.getActores();
            if(repartoSerie.contains(actor)){
                flagActua = true;
            }
            return flagActua;
        }catch(Exception e){
            throw new RuntimeException(
                    e.getMessage()
            );
        }
    }

    @Transactional
    public SerieDTO save(SerieDTO seriedto){
        try{
            // puede ser metodo booleano para comprobar transaccion O un void
            Serie serie = new Serie();
            if(seriedto == null){
                throw new RuntimeException(
                        "objeto seriedto no puede ser nulo"
                );
            }
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
        }catch(Exception e){
            throw new RuntimeException(
                    e.getMessage()
            );
        }
    }

    public Integer contarEpisodios(String titulo){
        try{
            // devuelve valores, nunca mensajes. INTEGER
            int contadorEps = 0;
            if(titulo == null || titulo.isBlank()){
                throw new RuntimeException(
                        "Serie no puede estar en blanco"
                );
            }
            Serie serie = serieRepo.findByTitulo(titulo)
                    .orElseThrow(() ->  new RuntimeException(
                            "Serie no encontrada"
                    ));
            List<Temporada> temporadas = serie.getTemporadas();
            for(Temporada temporada : temporadas){
                contadorEps += temporada.getNumEpisodios();
            }
            return contadorEps;
        }catch(Exception e){
            throw new RuntimeException(
                    e.getMessage()
            );
        }
    }

    @Transactional
    public SerieDTO update(Integer id, SerieDTO seriedto){
        try{
            // mejor devuelve booleano.
            if(id == null){
                throw new RuntimeException(
                        "id del objeto no puede ser nulo"
                );
            }
            if(seriedto == null){
                throw new RuntimeException(
                        "objeto seriedto no puede ser nulo"
                );
            }
            Serie existing = serieRepo.findById(id)
                    .orElseThrow(() -> new RuntimeException(
                        "Serie no encontrado"
                    ));
            existing.setTitulo(seriedto.getTitulo());
            existing.setAnnoEstreno(seriedto.getAnnoEstreno());
            existing.setActores(List.of());
            existing.setDirectors(List.of());
            existing.setTemporadas(List.of());
            existing.setGeneros(seriedto.getGeneros());
            Serie updatedSerie = serieRepo.save(existing);

            return new SerieDTO(
                    updatedSerie.getTitulo(),
                    updatedSerie.getAnnoEstreno(),
                    List.of(),//updatedSerie.getActores(),
                    List.of(),//updatedSerie.getDirectors(),
                    List.of(),//updatedSerie.getTemporadas(),
                    updatedSerie.getGeneros()
            );
        }catch(Exception e){
            throw new RuntimeException(
                    e.getMessage()
            );
        }
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
