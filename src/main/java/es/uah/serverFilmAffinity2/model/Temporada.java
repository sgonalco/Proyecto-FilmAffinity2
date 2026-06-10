package es.uah.serverFilmAffinity2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "series_temporada")
public class Temporada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "numero_temporada", nullable = false)
    private Integer numeroTemporada;

    @Column(name = "num_episodios", nullable = false)
    private Integer numEpisodios;

    @ManyToOne
    @JoinColumn(name = "serie_id")
    private Serie serie;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroTemporada() {
        return numeroTemporada;
    }

    public void setNumeroTemporada(Integer numeroTemporada) {
        this.numeroTemporada = numeroTemporada;
    }

    public Integer getNumEpisodios() {
        return numEpisodios;
    }

    public void setNumEpisodios(Integer numEpisodios) {
        this.numEpisodios = numEpisodios;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }
}
