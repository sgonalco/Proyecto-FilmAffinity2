package es.uah.serverFilmAffinity2.service;

import es.uah.serverFilmAffinity2.model.Actor;
import es.uah.serverFilmAffinity2.DAO.ActorRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    private final ActorRepo actorRepo;

    public ActorService(ActorRepo actorRepo, ActorRepo actorRepo1) {
        this.actorRepo = actorRepo1;
    }

    public List<Actor> findAll() {
        return this.actorRepo.findAll();
    }

    public Actor findByNombre(String nombre) {
        return actorRepo.findByNombre(nombre).orElseThrow(() -> new RuntimeException("actor name not found" + nombre));
    }

    public Actor findById(Integer id) {
        return this.actorRepo.findById(id).orElse(null);
    }

    public Actor updateActor(Integer id, Actor actor) {
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

    public Actor save(Actor actor) {
        return this.actorRepo.save(actor);
    }

    public void deleteById(Integer id) {
        this.actorRepo.deleteById(id);
    }

}
