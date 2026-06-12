package es.uah.serverFilmAffinity2.controller;

import es.uah.serverFilmAffinity2.DTO.SerieDTO;
import es.uah.serverFilmAffinity2.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/series")
public class SerieController {

    @Autowired
    private SerieService serieService;

    @GetMapping
    public List<SerieDTO> getlAll(){
        try{
            List<SerieDTO> series = serieService.getlAll();
            if(series.isEmpty()){
                throw new ResponseStatusException(
                        HttpStatus.NO_CONTENT,
                        "lista de serie vacia"
                );
            }
            return series;
        }catch(Exception ex){
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    ex.getMessage()
            );
        }
    }

    @GetMapping("/{id}")
    public SerieDTO getById(@PathVariable Integer id){
        try{
            if(id == null){
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "id no puede ser nulo"
                );
            }
            return serieService.findById(id);
        } catch (Exception ex) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    ex.getMessage()
            );
        }
    }

    @GetMapping("/titulo/{titulo}")
    public SerieDTO getByTitulo(@PathVariable String titulo){
        try{
            if(titulo == null){
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "nombre no puede ser nulo"
                );
            }
            return serieService.findByTitulo(titulo);
        }catch(Exception ex){
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    ex.getMessage()
            );
        }
    }

    @PostMapping("/crear")
    public SerieDTO createSerie(@RequestBody SerieDTO serieDTO){
        try{
            if(serieDTO == null){
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "objeto serie no puede ser nulo"
                );
            }
            return serieService.save(serieDTO);
        }catch(Exception ex){
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    ex.getMessage()
            );
        }
    }

    @PutMapping("/update/{id}")
    public SerieDTO update(@PathVariable Integer id, @RequestBody SerieDTO serieDTO){
        try{
            if(id == null || serieDTO == null){
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "id u objeto no pueden ser nulos"
                );
            }
            return serieService.update(id, serieDTO);
        }catch(Exception ex){
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    ex.getMessage()
            );
        }
    }

    @GetMapping("/{titulo}/{nombreActor}")
    public boolean checkActor(@PathVariable String titulo, @PathVariable String nombreActor){
        try{
            if(titulo == null || nombreActor == null){
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "nombres de serie o actor no puede ser nulos"
                );
            }
            return serieService.checkActor(titulo, nombreActor);
        }catch(Exception ex){
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    ex.getMessage()
            );
        }
    }

    @GetMapping("/contador de capitulos/{titulo}")
    public Integer contarCapitulos(@PathVariable String titulo){
        try{
            if(titulo == null || titulo.isEmpty()){
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "nombre no puede ser nulo"
                );
            }
            return serieService.contarEpisodios(titulo);
        }catch(Exception ex){
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    ex.getMessage()
            );
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        try{
            if(id == null){
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "id no puede ser nulo"
                );
            }
            serieService.delete(id);
        }catch(Exception ex){
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    ex.getMessage()
            );
        }
    }

}
