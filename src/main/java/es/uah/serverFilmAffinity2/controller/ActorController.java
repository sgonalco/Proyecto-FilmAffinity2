package es.uah.serverFilmAffinity2.controller;

import es.uah.serverFilmAffinity2.model.Actor;
import es.uah.serverFilmAffinity2.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActorController {

    @Autowired
    IActorService actorService;

    @GetMapping("/actores")
    public List<Actor> buscarTodos(){
        return actorService.buscarTodos();
    }

    @GetMapping("/actores/{id}")
    public Actor buscarActorPorId(@PathVariable("id") Integer id){
        return actorService.buscarActorPorId(id);
    }

    @GetMapping("/actores/nombre/{nombre}")
    public List<Actor> buscarActorPorNombre(@PathVariable("nombre") String nombre){
        return actorService.buscarActorPorNombre(nombre);
    }

    @PostMapping("/actores")
    public void guardarActor(@RequestBody Actor actor){
        actorService.guardarActor(actor);
    }

    @DeleteMapping("/actores/{id}")
    public void borrarActor(@PathVariable(value = "id") Integer idActor){
        actorService.eliminarActor(idActor);
    }

    @PutMapping("/actores")
    public void actualizarActor(@RequestBody Actor actor){
        actorService.actualizarActor(actor);
    }

}
