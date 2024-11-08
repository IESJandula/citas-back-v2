package es.iesjandula.proyectocitas.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    private String nombre;
    private String correo;
    private String telefono;

    // Relacion con Cita
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Cita> citas;


    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(idCliente, cliente.idCliente) && Objects.equals(nombre, cliente.nombre) && Objects.equals(correo, cliente.correo) && Objects.equals(telefono, cliente.telefono) && Objects.equals(citas, cliente.citas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, nombre, correo, telefono, citas);
    }
}
