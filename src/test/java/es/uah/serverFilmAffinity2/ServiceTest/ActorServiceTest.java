package es.uah.serverFilmAffinity2.ServiceTest;

import es.uah.serverFilmAffinity2.DAO.ActorRepo;
import es.uah.serverFilmAffinity2.DTO.ActorDTO;
import es.uah.serverFilmAffinity2.model.Actor;
import es.uah.serverFilmAffinity2.model.Pelicula;
import es.uah.serverFilmAffinity2.service.ActorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

@ExtendWith(MockitoExtension.class)
public class ActorServiceTest {

    // atributos de actor
    private static final Actor ACTOR = new Actor();
    private static final Integer ID = 1;
    private static final String NOMBRE = "Juan";
    private static final String FECHA_NACIMIENTO = "2026-19-06";
    private static final String PAIS_NACIMIENTO = "Spain";
    private static final List<Pelicula> PELICULAS = new ArrayList<>();

    @Mock
    private  ActorRepo actorRepo;

    @InjectMocks
    private ActorService actorService;

    @BeforeEach
    public void init() {
        ACTOR.setId(ID);
        ACTOR.setNombre(NOMBRE);
        ACTOR.setFechaNacimiento(FECHA_NACIMIENTO);
        ACTOR.setPaisNacimiento(PAIS_NACIMIENTO);
        ACTOR.setPeliculas(PELICULAS);
    }

    @Test
    public void findAllTest() {
        // Arrange
        Mockito.when(actorRepo.findAll())
                .thenReturn(Arrays.asList(ACTOR));
        // Act
        List<ActorDTO> result = actorService.findAll();
        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        ActorDTO actorDTO = result.getFirst();
        assertAll(
                () -> assertEquals(NOMBRE,
                        actorDTO.getNombre()),
                () -> assertEquals(FECHA_NACIMIENTO,
                        actorDTO.getFechaNacimiento()),
                () -> assertEquals(PAIS_NACIMIENTO,
                        actorDTO.getPaisNacimiento()),
                () -> assertEquals(PELICULAS,
                        actorDTO.getPeliculas())
        );
        verify(actorRepo).findAll();
    }


    @Test
    void findAllExceptionTest() {
        Mockito.when(actorRepo.findAll()).thenReturn(List.of());
        RuntimeException exception =
                assertThrows(
                        RuntimeException.class,
                        () -> actorService.findAll()
                );
        assertEquals(
                "Lista de actores vacia",
                exception.getMessage()
        );
    }

    @Test
    public void findActorByIdTest() {
        Mockito.when(actorRepo.findById(ID)).thenReturn(Optional.of(ACTOR));
        ActorDTO resultado = actorService.findById(ID);
        assertNotNull(resultado);
        assertEquals(NOMBRE, resultado.getNombre());
        assertEquals(FECHA_NACIMIENTO, resultado.getFechaNacimiento());
        assertEquals(PAIS_NACIMIENTO, resultado.getPaisNacimiento());
        assertEquals(PELICULAS, resultado.getPeliculas());
        verify(actorRepo).findById(ID);
    }

    @Test
    public void findActorByIdExceptionTest() {
        Mockito.when(actorRepo.findById(ID)).thenReturn(Optional.empty());
        RuntimeException exception =
                assertThrows(
                        RuntimeException.class,
                        () -> actorService.findById(ID)
                );
        assertEquals(
                "Actor con ID " + ID +  " no encontrado",
                exception.getMessage()
        );
    }

    @Test
    public void findActorByIdNullIdTest() {
        RuntimeException exception =
                assertThrows(
                        RuntimeException.class,
                        () -> actorService.findById(null)
                );
        assertEquals(
                "Actor con ID " + ID +  " no encontrado",
                exception.getMessage()
        );
        verifyNoInteractions(actorRepo);
    }

    @Test
    public void findActorByNombreTest() {
        Mockito.when(actorRepo.findByNombre(NOMBRE)).thenReturn(Optional.of(ACTOR));
        ActorDTO resultado = actorService.findByNombre(NOMBRE);
        assertNotNull(resultado);
        assertEquals(NOMBRE, resultado.getNombre());
        assertEquals(FECHA_NACIMIENTO, resultado.getFechaNacimiento());
        assertEquals(PAIS_NACIMIENTO, resultado.getPaisNacimiento());
        assertEquals(PELICULAS, resultado.getPeliculas());
        verify(actorRepo).findByNombre(NOMBRE);
    }

    @Test
    public void findActorByNombreNullIdTest() {
        RuntimeException exception =
                assertThrows(
                        RuntimeException.class,
                        () -> actorService.findByNombre(null)
                );
        assertEquals(
                "Actor: " + ID + " no encontrado",
                exception.getMessage()
        );
        verifyNoInteractions(actorRepo);
    }

    @Test
    public void findActorByNombreExceptionTest() {
        Mockito.when(actorRepo.findByNombre(NOMBRE)).thenReturn(Optional.empty());
        RuntimeException exception =
                assertThrows(
                        RuntimeException.class,
                        () -> actorService.findByNombre(NOMBRE)
                );
        assertEquals(
                "Actor: " + NOMBRE + " no encontrado",
                exception.getMessage()
        );
    }

    @Test
    public void saveActorTest() {
        Actor newActor = new Actor();
        newActor.setNombre(NOMBRE);
        newActor.setFechaNacimiento(FECHA_NACIMIENTO);
        newActor.setPaisNacimiento(PAIS_NACIMIENTO);
        newActor.setPeliculas(PELICULAS);

        ActorDTO newActorDto = new ActorDTO(
                newActor.getNombre(),
                newActor.getFechaNacimiento(),
                newActor.getPaisNacimiento(),
                newActor.getPeliculas()
        );

        Mockito.when(actorRepo.save(any(Actor.class))).thenReturn(newActor);
        ActorDTO resultado = actorService.save(newActorDto);
        assertNotNull(resultado);
        assertEquals(NOMBRE, resultado.getNombre());
        assertEquals(FECHA_NACIMIENTO, resultado.getFechaNacimiento());
        assertEquals(PAIS_NACIMIENTO, resultado.getPaisNacimiento());
        assertEquals(PELICULAS, resultado.getPeliculas());
        verify(actorRepo).save(newActor);
    }
}
