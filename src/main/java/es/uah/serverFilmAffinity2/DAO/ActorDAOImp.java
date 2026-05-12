package es.uah.serverFilmAffinity2.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import es.uah.serverFilmAffinity2.model.Actor;

@Repository
public class ActorDAOImp implements IActorDAO{

    @Autowired
    IActorJPA actorJPA;

    public ActorDAOImp(IActorJPA actorJPA) {
        this.actorJPA = actorJPA;
    }

    @Override
    public List<Actor> buscarTodos() {return actorJPA.findAll();}

    @Override
    public Actor buscarActorPorId(Integer idActor){
        Optional<Actor> optional = actorJPA.findById(idActor);
        return optional.orElse(null);
    }

    @Override
    public List<Actor> buscarActorPorNombre(String nombre){
        return actorJPA.findByNombre(nombre);
    }

    @Override
    public void guardarActor(Actor actor){
        actorJPA.save(actor);
    }

    @Override
    public void eliminarActor(Integer idActor){
        actorJPA.deleteById(idActor);
    }

    @Override
    public void actualizarActor(Actor actor){
        actorJPA.save(actor);
    }
}
