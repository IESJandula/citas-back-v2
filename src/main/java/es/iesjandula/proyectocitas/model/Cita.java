package es.iesjandula.proyectocitas.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idCita;
    private LocalDateTime fechaHoraCita;
    private String observaciones;
    private String estadoCita;

    // Relación con Cliente
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    // Relación con Empleado
    @ManyToOne
    @JoinColumn(name = "idEmpleado")
    private Empleado empleado;

    // Relación con Servicio
    @ManyToOne
    @JoinColumn(name = "idServicio")
    private Servicio servicio;

    // Relación con Pago
    @OneToOne(mappedBy = "cita")
    private Pago pago;

    public Long getIdCita() {
        return idCita;
    }

    public void setIdCita(Long id_Cita) {
        this.idCita = id_Cita;
    }


    public LocalDateTime getFechaHoraCita() {
        return fechaHoraCita;
    }

    public void setFechaHoraCita(LocalDateTime fecha_hora_Cita) {
        this.fechaHoraCita = fecha_hora_Cita;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Servicio getServicio() {
        return servicio;
    }
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public String getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(String estado_Cita) {
        this.estadoCita = estado_Cita;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cita cita)) return false;
        return Objects.equals(idCita, cita.idCita) && Objects.equals(fechaHoraCita, cita.fechaHoraCita) && Objects.equals(observaciones, cita.observaciones) && Objects.equals(estadoCita, cita.estadoCita);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCita, fechaHoraCita, observaciones, estadoCita);
    }
}
