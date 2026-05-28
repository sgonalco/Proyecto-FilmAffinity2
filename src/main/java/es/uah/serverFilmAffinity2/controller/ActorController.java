package es.uah.serverFilmAffinity2.controller;

import es.uah.serverFilmAffinity2.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import es.uah.serverFilmAffinity2.service.ActorService;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/actores")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping // find all
    public ResponseEntity<?> getAll() {
        try{
            List actores = actorService.findAll();
            if(actores.isEmpty()){
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("lista de actores vacia");
            }
            return ResponseEntity.ok(actores);
        }catch(Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error oucurred" + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        try {
            Actor actor = actorService.findById(id);

            if (actor == null) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Actor not found with id: " + id);
            }
            return ResponseEntity.ok(actor);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/nombre/{nombre}") // find by name
    public ResponseEntity<?> getByName(@PathVariable String nombre) {
        try{
            Actor actor = actorService.findByNombre(nombre);
            if (actor == null) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Actor not found with name: " + nombre);
            }
            return ResponseEntity.ok(actor);
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error ocurred: " + e.getMessage());
        }
    }

    @PostMapping("/crear") // create new actor
    public ResponseEntity<?> createActor(@Valid @RequestBody Actor actor) {
        try {
            if (actor == null) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Actor data cannot be null");
            }
            Actor savedActor = actorService.save(actor);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(savedActor);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred: " + e.getMessage());
        }
    }

    @PutMapping("/{id}") // update existing using id
    public ResponseEntity<?> updateActor(@Valid @PathVariable Integer id, @RequestBody Actor actor) {
        try{
            Actor updatedActor = actorService.updateActor(id, actor);
            if(updatedActor == null) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Actor not found with id: " + id);
            }
            return ResponseEntity.ok(updatedActor);
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred: " + e.getMessage());
        }
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
