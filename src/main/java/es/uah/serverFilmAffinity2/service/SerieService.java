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
                            s.getActores(),
                            s.getDirectors(),
                            s.getTemporadas(),
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
            Serie serie = serieRepo.findById(id).
                    orElseThrow(() ->  new RuntimeException(
                            "Serie no encontrado")
                    );
            SerieDTO serieDTO = new SerieDTO(
                    serie.getTitulo(),
                    serie.getAnnoEstreno(),
                    serie.getActores(),
                    serie.getDirectors(),
                    serie.getTemporadas(),
                    serie.getGeneros()
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
            serie.setActores(seriedto.getActores());
            serie.setDirectors(seriedto.getDirectores());
            serie.setTemporadas(seriedto.getTemporadas());
            serie.setGeneros(seriedto.getGeneros());
            Serie savedSerie = serieRepo.save(serie);

            return new  SerieDTO(
                    savedSerie.getTitulo(),
                    savedSerie.getAnnoEstreno(),
                    savedSerie.getActores(),
                    savedSerie.getDirectors(),
                    savedSerie.getTemporadas(),
                    savedSerie.getGeneros()
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
            existing.setActores(seriedto.getActores());
            existing.setDirectors(seriedto.getDirectores());
            existing.setTemporadas(seriedto.getTemporadas());
            existing.setGeneros(seriedto.getGeneros());
            Serie updatedSerie = serieRepo.save(existing);

            return new SerieDTO(
                    updatedSerie.getTitulo(),
                    updatedSerie.getAnnoEstreno(),
                    updatedSerie.getActores(),
                    updatedSerie.getDirectors(),
                    updatedSerie.getTemporadas(),
                    updatedSerie.getGeneros()
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
