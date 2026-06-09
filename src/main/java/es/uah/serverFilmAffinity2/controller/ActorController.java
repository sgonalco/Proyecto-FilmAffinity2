package es.uah.serverFilmAffinity2.controller;

import es.uah.serverFilmAffinity2.DTO.ActorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import es.uah.serverFilmAffinity2.service.ActorService;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/actores")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping // find all
    public List<ActorDTO> getAll() {
        try{
            if(actorService.findAll().isEmpty()) {
                throw new ResponseStatusException(
                        HttpStatus.NO_CONTENT,
                        "No se encontro el actor"
                );
            }
        }catch (Exception ex){
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    ex.getMessage()
            );
        }
        return actorService.findAll();
    }

    @GetMapping("/{id}")
    public ActorDTO getById(@PathVariable Integer id) {
        try{
            if(id == null || id < 0){
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Id no puede ser nulo"
                );
            }
        }catch (Exception ex){
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    ex.getMessage()
            );
        }
        return  actorService.findById(id);
    }

    @GetMapping("/nombre/{nombre}") // find by name
    public ActorDTO getByName(@PathVariable String nombre) {
        try {
            if(nombre == null || nombre.isBlank()){
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Nombre no puede ser nulo"
                );
            }
        }catch (Exception ex){
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    ex.getMessage()
            );
        }
        return actorService.findByNombre(nombre);
    }

    @PostMapping("/crear") // create new actor
    public ActorDTO createActor(@Valid @RequestBody ActorDTO actordto) {
        try{
            if(actordto == null){
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Actor no puede ser nulo"
                );
            }
        }catch (Exception ex){
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    ex.getMessage()
            );
        }
        return actorService.save(actordto);
    }

    @PutMapping("/{id}") // update existing using id
    public ActorDTO updateActor(@Valid @PathVariable Integer id, @RequestBody ActorDTO actordto) {
        try{
            if(id == null || id < 0){
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Id no puede ser nulo"
                );
            }
            if(actordto == null){
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Contenidos del actor no pueden ser nulos"
                );
            }
        }catch (Exception ex){
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    ex.getMessage()
            );
        }
        return actorService.updateActor(id, actordto);
    }

    @DeleteMapping("/{id}") // delete existing using id
    public ResponseEntity<?> deleteActor(@PathVariable Integer id) {
        try{
            boolean deletedActor = actorService.deleteById(id);
            if(!deletedActor) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Actor not found with id: " + id);
            }
            return  ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body("Actor has been deleted");
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred: " + e.getMessage());
        }
    }
}
