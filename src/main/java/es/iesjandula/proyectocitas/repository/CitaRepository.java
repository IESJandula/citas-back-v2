package es.iesjandula.proyectocitas.repository;

import es.iesjandula.proyectocitas.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
    // Metodo para verificar si una cita ya existe en un horario específico
    boolean existsByFechaHoraCita(LocalDateTime fechaHoraCita);

    // Metodo para obtener citas por fecha
    @Query("SELECT c FROM Cita c WHERE DATE(c.fechaHoraCita) = :fecha")
    List<Cita> findByFecha(LocalDate fecha);
}
