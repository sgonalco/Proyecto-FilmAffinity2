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
    private List<Director> directores;

    @ElementCollection
    @CollectionTable(
            name = "series_genero",
            joinColumns = @JoinColumn(name = "serie_id")
    )
    @Column(name = "genero")
    private List<String> generos;

    @OneToMany(
            mappedBy = "serie",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Temporada> temporadas;

    public List<Director> getDirectores() {
        return directores;
    }

    public void setDirectores(List<Director> directores) {
        this.directores = directores;
    }

    public List<String> getGeneros() {
        return generos;
    }

    public void setGeneros(List<String> generos) {
        this.generos = generos;
    }

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(List<Temporada> temporadas) {
        this.temporadas = temporadas;
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

    public List<Director> getDirectors() {
        return directores;
    }

    public void setDirectors(List<Director> directors) {
        this.directores = directors;
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
