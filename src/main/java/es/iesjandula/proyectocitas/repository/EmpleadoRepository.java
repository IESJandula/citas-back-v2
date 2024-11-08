package es.iesjandula.proyectocitas.repository;

import es.iesjandula.proyectocitas.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

}
