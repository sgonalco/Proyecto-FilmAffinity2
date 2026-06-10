package es.uah.serverFilmAffinity2.DTO;

import es.uah.serverFilmAffinity2.model.Actor;
import es.uah.serverFilmAffinity2.model.Director;

import java.util.List;

public class SerieDTO {
    private String titulo;
    private String annoEstreno;
    private String genero;
    private Integer numCaps;
    private List<Actor> actores;
    private List<Director> directores;

    public SerieDTO(String titulo, String annoEstreno,
                    String genero, Integer numCaps,
                    List<Actor> actores, List<Director> directores) {
        this.titulo = titulo;
        this.annoEstreno = annoEstreno;
        this.genero = genero;
        this.numCaps = numCaps;
        this.actores = actores;
        this.directores = directores;
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

    public List<Actor> getActores() {
        return actores;
    }

    public void setActores(List<Actor> actores) {
        this.actores = actores;
    }

    public List<Director> getDirectores() {
        return directores;
    }

    public void setDirectores(List<Director> directores) {
        this.directores = directores;
    }
}
