package es.uah.serverFilmAffinity2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import es.uah.serverFilmAffinity2.model.Pelicula;
import org.springframework.web.bind.annotation.RestController;
import es.uah.serverFilmAffinity2.service.IPeliculaService;

@RestController
public class PeliculaController {

    @Autowired
    private IPeliculaService peliculaService;

    @GetMapping("/peliculas")
    public List<Pelicula> buscarTodos(){
        return peliculaService.buscarTodos();
    }

    @GetMapping("/peliculas/{id}")
    public Pelicula buscarPeliculaPorId(@PathVariable int id){
        return peliculaService.buscarPeliculaPorId(id);
    }

    @GetMapping("/peliculas/titulo/{titulo}")
    public List<Pelicula> buscarPeliculaPorTitulo(@PathVariable String titulo){
        return peliculaService.buscarPeliculaPorTitulo(titulo);
    }

    @GetMapping("/peliculas/genero/{genero}")
    public List<Pelicula>  buscarPeliculaPorGenero(@PathVariable String genero){
        return peliculaService.buscarPeliculaPorGenero(genero);
    }

    @GetMapping("/peliculas/actor/{nombreActor}")
    public List<Pelicula> buscarPeliculaPorActor(@PathVariable String nombreActor){
        return peliculaService.buscarPeliculaPorActor(nombreActor);
    }

    @DeleteMapping("/peliculas/{id}")
    public void borrarActor(@PathVariable(value = "id") Integer idPelicula){
        peliculaService.borrarPelicula(idPelicula);
    }

    @PutMapping("/peliculas")
    public void actualizarPelicula(@Valid @RequestBody Pelicula pelicula){
        peliculaService.actualizarPelicula(pelicula);
    }

    @PostMapping("/peliculas")
    public void guardarPelicula(@Valid @RequestBody Pelicula pelicula){
        peliculaService.guardarPelicula(pelicula);
    }

}
