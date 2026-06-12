package es.uah.serverFilmAffinity2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "actores")
public class Actor extends ProfesionalCine{

    @Column(name = "pais_nacimiento", length = 80)
    private String paisNacimiento;

    @ManyToMany(mappedBy = "actores", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("actores")
    private List<Pelicula> peliculas;

    @ManyToMany(mappedBy = "actores", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("actores")
    private List<Serie> series;

    @Override
    public List<Serie> ObtenerFilmografiaSeries(){
        return series;
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(String paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public void addPelicula(Pelicula pelicula) {
        if (pelicula != null){
            getPeliculas().add(pelicula);
        }
    }

    public List<Serie> getSeries() {
        return series;
    }

    public void setSeries(List<Serie> series) {
        this.series = series;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(id, actor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}