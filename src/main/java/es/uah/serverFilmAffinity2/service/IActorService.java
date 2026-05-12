package es.uah.serverFilmAffinity2.service;

import es.uah.serverFilmAffinity2.model.Actor;

import java.util.List;

public interface IActorService {
    List<Actor> buscarTodos();

    Actor buscarActorPorId(Integer idActor);

    List<Actor> buscarActorPorNombre(String nombre);

    void guardarActor(Actor actor);

    void eliminarActor(Integer idActor);

    void actualizarActor(Actor actor);
}
