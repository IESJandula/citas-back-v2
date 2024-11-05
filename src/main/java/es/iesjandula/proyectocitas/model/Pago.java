package es.iesjandula.proyectocitas.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPago;

    private BigDecimal monto;
    private LocalDateTime fechaPago;

    @Enumerated(EnumType.STRING)
    private MetodoPago metodoPago;

    // Relación con Cita
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCita")
    private Cita cita;

    // Enum para el método de pago
    public enum MetodoPago {
        TARJETA_CREDITO, TARJETA_DEBITO, EFECTIVO, TRANSFERENCIA
    }


    // Getters y Setters

    public Long getIdPago() {
        return idPago;
    }

    public void setIdPago(Long idPago) {
        this.idPago = idPago;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pago pago = (Pago) o;
        return Objects.equals(idPago, pago.idPago) && Objects.equals(monto, pago.monto) && Objects.equals(fechaPago, pago.fechaPago) && metodoPago == pago.metodoPago && Objects.equals(cita, pago.cita);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPago, monto, fechaPago, metodoPago, cita);
    }
}

