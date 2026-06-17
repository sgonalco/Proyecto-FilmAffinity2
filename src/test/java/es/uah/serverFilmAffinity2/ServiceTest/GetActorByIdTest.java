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

import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetActorByIdTest {

    @Mock
    private ActorRepo actorRepo;

    @InjectMocks
    private ActorService actorService;

    @Test
    void shouldReturnActorDtoWhenActorExists() {
        Actor actor = new Actor();
        actor.setId(1);
        actor.setNombre("Tom Hanks");
        actor.setFechaNacimiento("1956-07-09");
        actor.setPaisNacimiento("USA");

        when(actorRepo.findById(1))
                .thenReturn(Optional.of(actor));

        // Act
        ActorDTO result = actorService.findById(1);

        // Assert
        assertNotNull(result);
        assertEquals("Tom Hanks", result.getNombre());
        assertEquals("1956-07-09", result.getFechanacimiento());
        assertEquals("USA", result.getPaisNacimiento());

        verify(actorRepo).findById(1);
    }

}
