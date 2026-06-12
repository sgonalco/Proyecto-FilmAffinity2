package es.uah.serverFilmAffinity2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "directores")
public class Director extends ProfesionalCine {

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("directores")
    @JoinTable(name = "pelicula_director",
                joinColumns = @JoinColumn(name = "director_id"),
                inverseJoinColumns = @JoinColumn(name = "pelicula_id"))
    private List<Pelicula> peliculas;

    @ManyToMany(mappedBy = "directores", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("directores")
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

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public List<Serie> getSeries() {
        return series;
    }

    public void setSeries(List<Serie> series) {
        this.series = series;
    }
}
