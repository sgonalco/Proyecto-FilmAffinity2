package es.uah.serverFilmAffinity2.controller;

import es.uah.serverFilmAffinity2.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import es.uah.serverFilmAffinity2.service.ActorService;

@RestController
@RequestMapping("/api/actores")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping // find all
    public List<Actor> getAll() {
        return actorService.findAll();
    }

    @GetMapping("/{id}") // find by id
    public Actor getById(@PathVariable Integer id) {
        return actorService.findById(id);
    }

    @GetMapping("/nombre/{nombre}") // find by name
    public Actor getByName(@PathVariable String nombre) {
        return  actorService.findByNombre(nombre);
    }

    @PostMapping("/crear") // create new actor
    public Actor createActor(@RequestBody Actor actor) {
        return actorService.save(actor);
    }

    @PutMapping("/{id}") // update existing using id
    public ResponseEntity<Actor> updateActor(@PathVariable Integer id, @RequestBody Actor actor) {
        Actor actorActualizado = actorService.updateActor(id, actor);
        return ResponseEntity.ok(actorActualizado);
    }

    @DeleteMapping("/delete") // delete existing using id
    public void deleteActor(@RequestBody Actor actor) {
        actorService.deleteById(actor.getId());
    }
}
