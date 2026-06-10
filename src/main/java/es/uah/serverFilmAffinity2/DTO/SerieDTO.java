package es.uah.serverFilmAffinity2.DTO;

import es.uah.serverFilmAffinity2.model.Actor;
import es.uah.serverFilmAffinity2.model.Director;
import es.uah.serverFilmAffinity2.model.Temporada;

import java.util.List;

public class SerieDTO {
    private String titulo;
    private String annoEstreno;
    private List<Actor> actores;
    private List<Director> directores;
    private List<Temporada> temporadas;
    private List<String> generos;

    public SerieDTO(String titulo, String annoEstreno,
                    List<Actor> actores, List<Director> directores,
                    List<Temporada> temporadas, List<String> generos) {
        this.titulo = titulo;
        this.annoEstreno = annoEstreno;
        this.actores = actores;
        this.directores = directores;
        this.temporadas = temporadas;
        this.generos = generos;
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

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(List<Temporada> temporadas) {
        this.temporadas = temporadas;
    }

    public List<String> getGeneros() {
        return generos;
    }

    public void setGeneros(List<String> generos) {
        this.generos = generos;
    }
}
