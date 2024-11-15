package es.iesjandula.proyectocitas.service;

import es.iesjandula.proyectocitas.model.Cita;
import es.iesjandula.proyectocitas.model.Cliente;
import es.iesjandula.proyectocitas.model.Servicio;
import es.iesjandula.proyectocitas.repository.CitaRepository;
import es.iesjandula.proyectocitas.repository.ClienteRepository;
import es.iesjandula.proyectocitas.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        // Validar si el horario está ocupado
        if (citaRepository.existsByFechaHoraCita(fechaHora)) {
            throw new RuntimeException("El horario está ocupado. No se puede registrar la cita.");
        }

        // Verificar que el cliente y servicio existan
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado."));
        Servicio servicio = servicioRepository.findById(idServicio)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado."));

        // Crear y guardar la nueva cita
        Cita nuevaCita = new Cita();
        nuevaCita.setCliente(cliente);
        nuevaCita.setFechaHoraCita(fechaHora);
        nuevaCita.setServicio(servicio);

        return citaRepository.save(nuevaCita);
    }

    // Obtener citas de un día específico
    public List<Cita> obtenerCitasPorDia(LocalDate fecha) {
        return citaRepository.findByFecha(fecha);
    }

    // Eliminar una cita
    public void eliminarCita(Long id) {
        citaRepository.deleteById(id);
    }
}

