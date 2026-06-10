package es.uah.serverFilmAffinity2.DTO;

import es.uah.serverFilmAffinity2.model.Actor;
import es.uah.serverFilmAffinity2.model.Director;

import java.util.List;

public class SerieDTO {
    private String titulo;
    private String annoEstreno;
    private String genero;
    private Integer numCaps;
    private List<Actor> actors;
    private List<Director> directors;

    public SerieDTO(String titulo, String annoEstreno,
                    String genero, Integer numCaps,
                    List<Actor> actors, List<Director> directors) {
        this.titulo = titulo;
        this.annoEstreno = annoEstreno;
        this.genero = genero;
        this.numCaps = numCaps;
        this.actors = actors;
        this.directors = directors;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnnoEstreno() {
        return annoEstreno;
    }

    public void setAnnoEstreno(String annoEstreno) {
        this.annoEstreno = annoEstreno;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getNumCaps() {
        return numCaps;
    }

    public void setNumCaps(Integer numCaps) {
        this.numCaps = numCaps;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }
}
