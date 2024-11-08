package es.iesjandula.proyectocitas.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEmpleado;

    private String nombre;
    private String correo;
    private String especialidad;

    // Relación con Horario
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idHorario", referencedColumnName = "id")
    private Horario horario;

    // Relación con Cita
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cita> citas;

    // Getters y Setters

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return Objects.equals(idEmpleado, empleado.idEmpleado) && Objects.equals(nombre, empleado.nombre) && Objects.equals(correo, empleado.correo) && Objects.equals(especialidad, empleado.especialidad) && Objects.equals(horario, empleado.horario) && Objects.equals(citas, empleado.citas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmpleado, nombre, correo, especialidad, horario, citas);
    }
}
