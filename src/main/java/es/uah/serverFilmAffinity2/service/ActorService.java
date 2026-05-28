package es.uah.serverFilmAffinity2.service;

import es.uah.serverFilmAffinity2.model.Actor;
import es.uah.serverFilmAffinity2.DAO.ActorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ActorService {

    @Autowired
    private ActorRepo actorRepo;

    public List<Actor> findAll() {
        return actorRepo.findAll();
    }

    public Actor findByNombre(String nombre) {
        return actorRepo.findByNombre(nombre)
                .orElseThrow(() -> new RuntimeException("actor name not found" + nombre));
    }

    public Actor findById(Integer id) {
        return this.actorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("actor not found with id: " + id));
    }

    public Actor save(Actor actor) {
        if(actor == null) {
            throw new IllegalArgumentException("actor cannot be null");
        }
        if (actor.getNombre() == null || actor.getNombre().isBlank()) {
            throw new IllegalArgumentException("Actor name cannot be empty");
        }
        return actorRepo.save(actor);
    }

    public Actor updateActor(Integer id, Actor actor) {
        if(id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        if(actor == null) {
            throw new IllegalArgumentException("actor cannot be null");
        }
        Actor existing = actorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Actor not found with id: " + id));

        // Only overwrite fields that were actually sent
        if (actor.getNombre() != null) {
            existing.setNombre(actor.getNombre());
        }
        if (actor.getFechaNacimiento() != null) {
            existing.setFechaNacimiento(actor.getFechaNacimiento());
        }
        if (actor.getPaisNacimiento() != null) {
            existing.setPaisNacimiento(actor.getPaisNacimiento());
        }
        return actorRepo.save(existing); // save() updates because id already exists
    }

    public boolean deleteById(Integer id) {
        if(id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }

        if (!actorRepo.existsById(id)) {
            return false;
        }
        actorRepo.deleteById(id);
        return true;
    }

}
