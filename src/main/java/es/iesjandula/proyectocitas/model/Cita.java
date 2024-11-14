package es.iesjandula.proyectocitas.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id_Cita;
    private LocalDateTime fecha_hora_Cita;
    private String observaciones;
    private String estado_Cita;

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

    public Long getId_Cita() {
        return id_Cita;
    }

    public void setId_Cita(Long id_Cita) {
        this.id_Cita = id_Cita;
    }


    public LocalDateTime getFecha_hora_Cita() {
        return fecha_hora_Cita;
    }

    public void setFecha_hora_Cita(LocalDateTime fecha_hora_Cita) {
        this.fecha_hora_Cita = fecha_hora_Cita;
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

    public String getEstado_Cita() {
        return estado_Cita;
    }

    public void setEstado_Cita(String estado_Cita) {
        this.estado_Cita = estado_Cita;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cita cita)) return false;
        return Objects.equals(id_Cita, cita.id_Cita) && Objects.equals(fecha_hora_Cita, cita.fecha_hora_Cita) && Objects.equals(observaciones, cita.observaciones) && Objects.equals(estado_Cita, cita.estado_Cita);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_Cita, fecha_hora_Cita, observaciones, estado_Cita);
    }
}
