package es.iesjandula.proyectocitas.repository;

import es.iesjandula.proyectocitas.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
    // Método para verificar si una cita ya existe en un horario específico
    boolean existsByFecha_hora_Cita(LocalDateTime fechaHora);

    // Método para obtener citas por fecha
    List<Cita> findByFecha_hora_CitaBetween(LocalDateTime inicio, LocalDateTime fin);
}
