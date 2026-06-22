package es.uah.serverFilmAffinity2.DTO;

import es.uah.serverFilmAffinity2.model.Pelicula;

import java.util.List;

public class ActorDTO {
    private String nombre;
    private String fechanacimiento;
    private String paisNacimiento;
    private List<Pelicula> peliculas;

    public ActorDTO(String nombre, String fechanacimiento,
                    String paisNacimiento, List<Pelicula> peliculas) {
        this.nombre = nombre;
        this.fechanacimiento = fechanacimiento;
        this.paisNacimiento = paisNacimiento;
        this.peliculas = peliculas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
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
}
