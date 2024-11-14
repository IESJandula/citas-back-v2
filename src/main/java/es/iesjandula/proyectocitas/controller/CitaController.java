package es.iesjandula.proyectocitas.controller;

import es.iesjandula.proyectocitas.model.Cita;
import es.iesjandula.proyectocitas.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    // Endpoint para registrar una cita
    @PostMapping("/registrar")
    public ResponseEntity<String> registrarCita(
            @RequestParam Long idCliente,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime hora,
            @RequestParam Long idServicio) {

        LocalDateTime fechaHora = LocalDateTime.of(fecha, hora);
        try {
            Cita nuevaCita = citaService.registrarCita(idCliente, fechaHora, idServicio);
            return ResponseEntity.status(HttpStatus.CREATED).body("Cita registrada con éxito: " + nuevaCita.getId_Cita());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // Endpoint para obtener todas las citas de un día específico
    @GetMapping("/dia")
    public ResponseEntity<List<Cita>> obtenerCitasPorDia(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {

        List<Cita> citas = citaService.obtenerCitasPorDia(fecha);
        return ResponseEntity.ok(citas);
    }
}
