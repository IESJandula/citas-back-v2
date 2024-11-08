package es.iesjandula.proyectocitas.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHorario;

    private String diaSemana;
    private String horaInicio;
    private String horaFin;

    // Relacion con Empleado
    @OneToOne(mappedBy = "horario", fetch = FetchType.LAZY)
    private Empleado empleado;



    public Long getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Long idHorario) {
        this.idHorario = idHorario;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horario horario = (Horario) o;
        return Objects.equals(idHorario, horario.idHorario) && Objects.equals(diaSemana, horario.diaSemana) && Objects.equals(horaInicio, horario.horaInicio) && Objects.equals(horaFin, horario.horaFin) && Objects.equals(empleado, horario.empleado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHorario, diaSemana, horaInicio, horaFin, empleado);
    }
}
