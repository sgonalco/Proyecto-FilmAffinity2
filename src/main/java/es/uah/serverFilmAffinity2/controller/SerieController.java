package es.uah.serverFilmAffinity2.controller;

import es.uah.serverFilmAffinity2.DTO.SerieDTO;
import es.uah.serverFilmAffinity2.service.SerieService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/series")
@Validated
public class SerieController {

    @Autowired
    private SerieService serieService;

    @GetMapping
    public List<SerieDTO> getlAll(){
        return serieService.getlAll();
    }

    @GetMapping("/{id}")
    public SerieDTO getById(@PathVariable @Positive Integer id){
        return serieService.findById(id);
    }

    @GetMapping("/titulo/{titulo}")
    public SerieDTO getByTitulo(@PathVariable String titulo){
        return serieService.findByTitulo(titulo);
    }

    @PostMapping("/crear")
    public SerieDTO createSerie(@RequestBody @Valid SerieDTO serieDTO){
        return serieService.save(serieDTO);
    }

    @PutMapping("/update/{id}")
    public SerieDTO update(@PathVariable @Positive Integer id,
                           @RequestBody @Valid SerieDTO serieDTO){
        return serieService.update(id, serieDTO);
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
