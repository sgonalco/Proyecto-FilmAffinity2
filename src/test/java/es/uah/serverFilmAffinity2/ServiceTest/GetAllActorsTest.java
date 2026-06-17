package es.uah.serverFilmAffinity2.ServiceTest;

import es.uah.serverFilmAffinity2.DAO.ActorRepo;
import es.uah.serverFilmAffinity2.DTO.ActorDTO;
import es.uah.serverFilmAffinity2.model.Actor;
import es.uah.serverFilmAffinity2.service.ActorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetAllActorsTest {

    @Mock
    private ActorRepo actorRepo;

    @InjectMocks
    private ActorService actorService;

    @Test
    void shouldReturnAllActors(){
        Actor actor = new Actor();
        actor.setNombre("Juan");
        actor.setFechaNacimiento("1956-07-09");
        actor.setPaisNacimiento("USA");

        List<Actor> actors = List.of(actor);

        when(actorRepo.findAll()).thenReturn(actors);

        List<ActorDTO> resultList = actorService.findAll();
        assertNotNull(resultList);
        assertEquals(1, resultList.size());
        assertFalse(resultList.isEmpty());

    }
}
