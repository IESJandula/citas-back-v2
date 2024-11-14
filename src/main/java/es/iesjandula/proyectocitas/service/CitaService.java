package es.iesjandula.proyectocitas.service;

import es.iesjandula.proyectocitas.model.Cita;
import es.iesjandula.proyectocitas.model.Cliente;
import es.iesjandula.proyectocitas.model.Empleado;
import es.iesjandula.proyectocitas.model.Servicio;
import es.iesjandula.proyectocitas.repository.CitaRepository;
import es.iesjandula.proyectocitas.repository.ClienteRepository;
import es.iesjandula.proyectocitas.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    // Obtener todas las citas
    public List<Cita> obtenerTodascitas() {
        return citaRepository.findAll();
    }

    // Obtener una cita por su id
    public Optional<Cita> getCitaById(Long id) {
        return citaRepository.findById(id);
    }

    // Registrar una cita nueva
    public Cita registrarCita(Long idCliente, LocalDateTime fechaHora, Long idServicio) {
        // Validar si existe una cita en la misma fecha y hora
        boolean horarioOcupado = citaRepository.findAll().stream()
                .anyMatch(cita -> cita.getFecha_hora_Cita().equals(fechaHora));

        if (horarioOcupado) {
            throw new RuntimeException("El horario está ocupado. No se puede registrar la cita.");
        }

        // Verificar que el cliente y servicio existan
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado."));
        Servicio servicio = servicioRepository.findById(idServicio)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado."));

        // Crear la nueva cita
        Cita nuevaCita = new Cita();
        nuevaCita.setCliente(cliente);
        nuevaCita.setFecha_hora_Cita(fechaHora);
        nuevaCita.setServicio(servicio);

        // Guardar la cita
        return citaRepository.save(nuevaCita);
    }

    // Crear una cita
    public Cita guardarCita(Cita cita) {
        return citaRepository.save(cita);
    }

    // Actualizar una cita existente
    public Cita actualizarCita(Long id, Cita citaDetails) {
        return citaRepository.findById(id)
                .map(cita -> {
                    // Actualiza los campos de la cita según los datos de `citaDetails`
                    cita.setFecha_hora_Cita(citaDetails.getFecha_hora_Cita());
                    cita.setObservaciones(citaDetails.getObservaciones());
                    cita.setEstado_Cita(citaDetails.getEstado_Cita());

                    // Actualizar cliente, empleado y servicio
                    if (citaDetails.getCliente() != null) {
                        cita.setCliente(citaDetails.getCliente());
                    }
                    if (citaDetails.getEmpleado() != null) {
                        cita.setEmpleado(citaDetails.getEmpleado());
                    }
                    if (citaDetails.getServicio() != null) {
                        cita.setServicio(citaDetails.getServicio());
                    }

                    // Guardar y retornar la cita actualizada
                    return citaRepository.save(cita);
                })
                .orElseGet(() -> {
                    // Si no existe, guarda la cita con el ID proporcionado
                    citaDetails.setId_Cita(id);
                    return citaRepository.save(citaDetails);
                });
    }

    // Eliminar cita
    public void eliminarCita(Long id) {
        citaRepository.deleteById(id);
    }
}
