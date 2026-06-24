package es.uah.serverFilmAffinity2.controller;

import es.uah.serverFilmAffinity2.DTO.ActorDTO;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import es.uah.serverFilmAffinity2.service.ActorService;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api/actores")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping // find all
    public List<ActorDTO> getAll() {
        return actorService.findAll();
    }

    @GetMapping("/{id}")
    public ActorDTO getById(@PathVariable @Positive Integer id) {
        return  actorService.findById(id);
    }

    @GetMapping("/nombre/{nombre}") // find by name
    public ActorDTO getByName(@PathVariable String nombre) {
        return actorService.findByNombre(nombre);
    }

    @PostMapping("/crear") // create new actor
    public ActorDTO createActor(@Valid @RequestBody ActorDTO actordto) {
        return actorService.save(actordto);
    }

    @PutMapping("/{id}") // update existing using id
    public ActorDTO updateActor(@PathVariable @Positive Integer id,
                                @RequestBody @Valid ActorDTO actordto) {
        return actorService.updateActor(id, actordto);
    }

    @DeleteMapping("/{id}") // delete existing using id
    public ResponseEntity<Void> deleteActor(@PathVariable @Positive Integer id) {
        actorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
