package es.uah.serverFilmAffinity2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "series")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank(message = "titulo no puede estar en blanco")
    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "annoEstreno")
    private String annoEstreno;

    @NotBlank(message = "genero no puede estar en blanco")
    @Column(name = "genero", nullable = false)
    private String genero;

    @NotNull(message = "número de caps no puede estar en blanco")
    @Column(name = "numCaps", nullable = false)
    private Integer numCaps;

    @ManyToMany
    @JoinTable(
            name = "series_actor",
            joinColumns = @JoinColumn(name = "serie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actores;

    @ManyToMany
    @JoinTable(
            name = "series_director",
            joinColumns = @JoinColumn(name = "serie_id"),
            inverseJoinColumns = @JoinColumn(name = "director_id")
    )
    private List<Director> directors;

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

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return Objects.equals(id, serie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
