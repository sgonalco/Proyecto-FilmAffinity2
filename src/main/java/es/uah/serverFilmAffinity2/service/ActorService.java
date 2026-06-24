package es.uah.serverFilmAffinity2.service;

import es.uah.serverFilmAffinity2.DTO.ActorDTO;
import es.uah.serverFilmAffinity2.exceptions.BadRequestException;
import es.uah.serverFilmAffinity2.exceptions.ConflictException;
import es.uah.serverFilmAffinity2.exceptions.ResourceNotFoundException;
import es.uah.serverFilmAffinity2.model.Actor;
import es.uah.serverFilmAffinity2.DAO.ActorRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    @Autowired
    private ActorRepo actorRepo;
    private static final String actorConId = "Actor con ID ";
    private static final String noEncontrado = " no encontrado";

    public List<ActorDTO> findAll() {
        List<Actor> actores = actorRepo.findAll();
        if(actores.isEmpty()){
            throw new ResourceNotFoundException(
                    "Lista de actores vacia"
            );
        }
        return actores.stream()
                .map(actor -> new ActorDTO(
                        actor.getNombre(),
                        actor.getFechaNacimiento(),
                        actor.getPaisNacimiento(),
                        List.of()//actor.getPeliculas()
                ))
                .toList();
    }

    public ActorDTO findById(Integer id) {
        Actor actor = actorRepo.findById(id).
                orElseThrow(() -> new ResourceNotFoundException(
                        actorConId + id + noEncontrado
                ));
        return new ActorDTO(actor.getNombre(),
                actor.getFechaNacimiento(),
                actor.getPaisNacimiento(),
                List.of()//actor.getPeliculas()
        );
    }

    public ActorDTO findByNombre(String nombre) {
        Actor actor = actorRepo.findByNombre(nombre)
                .orElseThrow(() -> new ResourceNotFoundException("Actor: " + nombre + noEncontrado));
        return new ActorDTO(actor.getNombre(),
                actor.getFechaNacimiento(),
                actor.getPaisNacimiento(),
                List.of()//actor.getPeliculas()
        );
    }

    @Transactional
    public ActorDTO save(ActorDTO actordto) {
        if(actorRepo.existsByNombre(actordto.getNombre())) {
            throw new ConflictException(
                    "Ya existe un actor con ese nombre"
            );
        }
        // agregar el metodo repo existsByNombre(actordto.getNombre()) + ConflictException
        Actor actor = new Actor();
        actor.setNombre(actordto.getNombre());
        actor.setPaisNacimiento(actordto.getPaisNacimiento());
        actor.setFechaNacimiento(actordto.getFechaNacimiento());
        actor.setPeliculas(actordto.getPeliculas());

        Actor savedActor = actorRepo.save(actor);

        return new ActorDTO(
                savedActor.getNombre(),
                savedActor.getFechaNacimiento(),
                savedActor.getPaisNacimiento(),
                List.of()//savedActor.getPeliculas()
        );
    }

    @Transactional
    public ActorDTO updateActor(Integer id, ActorDTO actordto) {
        if(id == null || actordto == null){
            throw new BadRequestException(
                    "id o dto no pueden ser nulos"
            );
        }
        Actor existing = actorRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        actorConId + id + noEncontrado
                ));
        existing.setNombre(actordto.getNombre());
        existing.setPaisNacimiento(actordto.getPaisNacimiento());
        existing.setFechaNacimiento(actordto.getFechaNacimiento());
        existing.setPeliculas(List.of());

        Actor savedActor = actorRepo.save(existing);

        return new ActorDTO(
                savedActor.getNombre(),
                savedActor.getFechaNacimiento(),
                savedActor.getPaisNacimiento(),
                List.of()//savedActor.getPeliculas()
        );
    }

    @Transactional
    public void deleteById(Integer id) {
        Actor actor = actorRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        actorConId + id + noEncontrado
                ));
        actorRepo.delete(actor);
    }
}
