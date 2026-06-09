package es.uah.serverFilmAffinity2.service;

import es.uah.serverFilmAffinity2.DTO.ActorDTO;
import es.uah.serverFilmAffinity2.model.Actor;
import es.uah.serverFilmAffinity2.DAO.ActorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    @Autowired
    private ActorRepo actorRepo;

    public List<ActorDTO> findAll() {
        List<Actor> actores = actorRepo.findAll();
        return actores.stream()
                .map(actor -> new ActorDTO(
                        actor.getNombre(),
                        actor.getFechaNacimiento(),
                        actor.getPaisNacimiento(),
                        actor.getPeliculas()))
                .toList();
    }

    public ActorDTO findByNombre(String nombre) {
        Actor actor = actorRepo.findByNombre(nombre)
                .orElseThrow(() -> new RuntimeException("Actor no encontrado"));
        ActorDTO actorDTO = new ActorDTO(actor.getNombre(),
                actor.getFechaNacimiento(),
                actor.getPaisNacimiento(),
                actor.getPeliculas());
        return actorDTO;
    }

    public ActorDTO findById(Integer id) {
        Actor actor = actorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Actor no encontrado"));
        ActorDTO actorDTO = new ActorDTO(actor.getNombre(),
                actor.getFechaNacimiento(),
                actor.getPaisNacimiento(),
                actor.getPeliculas());
        return actorDTO;
    }

    public ActorDTO save(ActorDTO actordto) {
        Actor actor = new Actor();
        actor.setNombre(actordto.getNombre());
        actor.setPaisNacimiento(actordto.getPaisNacimiento());
        actor.setFechaNacimiento(actordto.getFechanacimiento());
        actor.setPeliculas(actordto.getPeliculas());

        Actor savedActor = actorRepo.save(actor);

        return new ActorDTO(
                savedActor.getNombre(),
                savedActor.getFechaNacimiento(),
                savedActor.getPaisNacimiento(),
                savedActor.getPeliculas()
        );
    }

    public ActorDTO updateActor(Integer id, ActorDTO actordto) {
        Actor existing = actorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Actor no encontrado"));
        existing.setNombre(actordto.getNombre());
        existing.setPaisNacimiento(actordto.getPaisNacimiento());
        existing.setFechaNacimiento(actordto.getFechanacimiento());
        existing.setPeliculas(actordto.getPeliculas());

        Actor savedActor = actorRepo.save(existing);

        return new ActorDTO(
                savedActor.getNombre(),
                savedActor.getFechaNacimiento(),
                savedActor.getPaisNacimiento(),
                savedActor.getPeliculas()
        );
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
