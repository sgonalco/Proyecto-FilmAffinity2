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
        try{
            List<Actor> actores = actorRepo.findAll();
            if(actores.isEmpty()){
                throw new RuntimeException(
                        "Lista de actores no encontrada"
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
        }catch(Exception e){
            throw new RuntimeException(
                    e.getMessage()
            );
        }
    }

    public ActorDTO findByNombre(String nombre) {
        try{
            if(nombre == null || nombre.isBlank()){
                throw new RuntimeException(
                        "El nombre del actor no puede ser nulo"
                );
            }
            Actor actor = actorRepo.findByNombre(nombre)
                    .orElseThrow(() -> new RuntimeException("Actor no encontrado"));
            ActorDTO actorDTO = new ActorDTO(actor.getNombre(),
                    actor.getFechaNacimiento(),
                    actor.getPaisNacimiento(),
                    List.of()//actor.getPeliculas()
            );
            return actorDTO;
        }catch(Exception e){
            throw new RuntimeException(
                    e.getMessage()
            );
        }
    }

    public ActorDTO findById(Integer id) {
        try{
            if(id == null){
                throw new RuntimeException(
                        "El id del actor no puede ser nulo"
                );
            }
            Actor actor = actorRepo.findById(id).orElseThrow(() -> new RuntimeException("Actor no encontrado"));;
            ActorDTO actorDTO = new ActorDTO(actor.getNombre(),
                    actor.getFechaNacimiento(),
                    actor.getPaisNacimiento(),
                    List.of()//actor.getPeliculas()
            );
            return actorDTO;
        }catch(Exception e){
            throw new RuntimeException(
                    e.getMessage()
            );
        }
    }

    public ActorDTO save(ActorDTO actordto) {
        try{
            if(actordto == null){
                throw new RuntimeException(
                        "El actor no puede ser nulo"
                );
            }
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
                    List.of()//savedActor.getPeliculas()
            );
        }catch(Exception e){
            throw new RuntimeException(
                    e.getMessage()
            );
        }
    }

    public ActorDTO updateActor(Integer id, ActorDTO actordto) {
        try{
            if(id == null){
                throw new RuntimeException(
                        "El id del actor no puede ser nulo"
                );
            }
            Actor existing = actorRepo.findById(id)
                    .orElseThrow(() -> new RuntimeException("Actor no encontrado"));
            existing.setNombre(actordto.getNombre());
            existing.setPaisNacimiento(actordto.getPaisNacimiento());
            existing.setFechaNacimiento(actordto.getFechanacimiento());
            existing.setPeliculas(List.of());

            Actor savedActor = actorRepo.save(existing);

            return new ActorDTO(
                    savedActor.getNombre(),
                    savedActor.getFechaNacimiento(),
                    savedActor.getPaisNacimiento(),
                    List.of()//savedActor.getPeliculas()
            );
        }catch(Exception e){
            throw new RuntimeException(
                    e.getMessage()
            );
        }
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
