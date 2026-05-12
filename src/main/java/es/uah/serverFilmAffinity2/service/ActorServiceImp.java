package es.uah.serverFilmAffinity2.service;

import es.uah.serverFilmAffinity2.DAO.IActorDAO;
import es.uah.serverFilmAffinity2.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImp implements IActorService{

    @Autowired
    IActorDAO actorDAO;

    @Override
    public List<Actor> buscarTodos(){
        return actorDAO.buscarTodos();
    }

    @Override
    public Actor buscarActorPorId(Integer idActor){
        return actorDAO.buscarActorPorId(idActor);
    }

    @Override
    public List<Actor> buscarActorPorNombre(String nombre){
        return actorDAO.buscarActorPorNombre(nombre);
    }

    @Override
    public void guardarActor(Actor actor){
        actorDAO.guardarActor(actor);
    }

    @Override
    public void eliminarActor(Integer idActor){
        actorDAO.eliminarActor(idActor);
    }

    @Override
    public void actualizarActor(Actor actor){
        actorDAO.actualizarActor(actor);
    }
}
