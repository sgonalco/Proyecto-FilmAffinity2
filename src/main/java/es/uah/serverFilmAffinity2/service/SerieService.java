package es.uah.serverFilmAffinity2.service;

import es.uah.serverFilmAffinity2.DAO.SerieRepo;
import es.uah.serverFilmAffinity2.DTO.SerieDTO;
import es.uah.serverFilmAffinity2.model.Serie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SerieService {

    @Autowired
    private SerieRepo serieRepo;

    public List<SerieDTO> getlAll(){
        try{
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
                            s.getGenero(),
                            s.getNumCaps(),
                            s.getActores(),
                            s.getDirectors()))
                    .toList();
        }catch(Exception e){
            throw new RuntimeException(
                    e.getMessage()
            );
        }
    }

    public SerieDTO findById(Integer id){
        try{
            Serie serie = serieRepo.findById(id).
                    orElseThrow(() ->  new RuntimeException(
                            "Serie no encontrado")
                    );
            SerieDTO serieDTO = new SerieDTO(
                    serie.getTitulo(),
                    serie.getAnnoEstreno(),
                    serie.getGenero(),
                    serie.getNumCaps(),
                    serie.getActores(),
                    serie.getDirectors()
            );
            return serieDTO;
        }catch(Exception e){
            throw new RuntimeException(
                    e.getMessage()
            );
        }
    }

    public SerieDTO save(SerieDTO seriedto){
        try{
            Serie serie = new Serie();
            if(seriedto == null){
                throw new RuntimeException(
                        "objeto seriedto no puede ser nulo"
                );
            }
            serie.setTitulo(seriedto.getTitulo());
            serie.setAnnoEstreno(seriedto.getAnnoEstreno());
            serie.setGenero(seriedto.getGenero());
            serie.setNumCaps(seriedto.getNumCaps());
            serie.setActores(seriedto.getActores());
            serie.setDirectors(seriedto.getDirectores());
            Serie savedSerie = serieRepo.save(serie);

            return new  SerieDTO(
                    savedSerie.getTitulo(),
                    savedSerie.getAnnoEstreno(),
                    savedSerie.getGenero(),
                    savedSerie.getNumCaps(),
                    savedSerie.getActores(),
                    savedSerie.getDirectors()
            );
        }catch(Exception e){
            throw new RuntimeException(
                    e.getMessage()
            );
        }
    }

    public SerieDTO update(Integer id, SerieDTO seriedto){
        try{
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
            existing.setGenero(seriedto.getGenero());
            existing.setNumCaps(seriedto.getNumCaps());
            existing.setActores(seriedto.getActores());
            existing.setDirectors(seriedto.getDirectores());
            Serie updatedSerie = serieRepo.save(existing);

            return new  SerieDTO(
                    updatedSerie.getTitulo(),
                    updatedSerie.getAnnoEstreno(),
                    updatedSerie.getGenero(),
                    updatedSerie.getNumCaps(),
                    updatedSerie.getActores(),
                    updatedSerie.getDirectors()
            );
        }catch(Exception e){
            throw new RuntimeException(
                    e.getMessage()
            );
        }
    }

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
