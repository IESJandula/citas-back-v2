package es.iesjandula.proyectocitas.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id_Cita;
    private Long id_Cliente;
    private Long id_Empleado;
    private Long id_Servicio;
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

    public Long getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(Long id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public Long getId_Empleado() {
        return id_Empleado;
    }

    public void setId_Empleado(Long id_Empleado) {
        this.id_Empleado = id_Empleado;
    }

    public Long getId_Servicio() {
        return id_Servicio;
    }

    public void setId_Servicio(Long id_Servicio) {
        this.id_Servicio = id_Servicio;
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
        return Objects.equals(id_Cita, cita.id_Cita) && Objects.equals(id_Cliente, cita.id_Cliente) && Objects.equals(id_Empleado, cita.id_Empleado) && Objects.equals(id_Servicio, cita.id_Servicio) && Objects.equals(fecha_hora_Cita, cita.fecha_hora_Cita) && Objects.equals(observaciones, cita.observaciones) && Objects.equals(estado_Cita, cita.estado_Cita);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_Cita, id_Cliente, id_Empleado, id_Servicio, fecha_hora_Cita, observaciones, estado_Cita);
    }
}
