package es.iesjandula.proyectocitas.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Servicio {

    @OneToMany(mappedBy = "servicio",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Cita> citas;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idServicio;
    private String nombre;
    private String descripcion;
    private Integer duracion;

    public Long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "idServicio=" + idServicio +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", duracion=" + duracion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Servicio servicio)) return false;
        return Objects.equals(idServicio, servicio.idServicio) && Objects.equals(nombre, servicio.nombre) && Objects.equals(descripcion, servicio.descripcion) && Objects.equals(duracion, servicio.duracion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idServicio, nombre, descripcion, duracion);
    }
}
