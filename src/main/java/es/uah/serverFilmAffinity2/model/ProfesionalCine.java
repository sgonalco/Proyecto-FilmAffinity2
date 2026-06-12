package es.uah.serverFilmAffinity2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@MappedSuperclass
public abstract class ProfesionalCine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected Integer id;

    @NotBlank(message = "name cannot be empty")
    @Size(max = 120)
    @Column(name = "nombre", nullable = false)
    protected String nombre;

    @Column(name = "fecha_nacimiento")
    protected String fechaNacimiento;

    public abstract List<Serie> ObtenerFilmografiaSeries();
}
