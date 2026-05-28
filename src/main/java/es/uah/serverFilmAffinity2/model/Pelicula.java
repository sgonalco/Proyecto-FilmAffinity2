package es.uah.serverFilmAffinity2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.List;
import jakarta.validation.constraints.*;
import java.util.Objects;

@Entity
@Table(name = "peliculas")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank(message = "title cannot be blank")
    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;

    @Column(name = "anio", nullable = false)
    private Integer anio;

    @Column(name = "duracion")
    private Integer duracion;

    @Column(name = "pais", length = 80)
    private String pais;

    @Column(name = "direccion", length = 150)
    private String direccion;

    @Column(name = "genero", length = 80)
    private String genero;

    @Lob
    @Column(name = "sinopsis")
    private String sinopsis;

    @Column(name = "portada")
    private String portada;

    @ManyToMany
    @JsonIgnoreProperties("peliculas")
    @JoinTable(name = "reparto",
                joinColumns = @JoinColumn(name = "pelicula_id"),
                inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actor> actores;

    @ManyToMany(mappedBy = "peliculas")
    @JsonIgnoreProperties("peliculas")
    private List<Director> directores;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public List<Actor> getActores() {
        return actores;
    }

    public void setActores(List<Actor> actores) {
        this.actores = actores;
    }

    public void addActor(Actor actor) {
        if (actor != null) {
            getActores().add(actor);
        }
    }

    public void removeActor(Actor actor) {
        if (actor != null) {
            getActores().remove(actor);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return Objects.equals(id, pelicula.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}