package es.iesjandula.proyectocitas.repository;

import es.iesjandula.proyectocitas.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositroy extends JpaRepository<Cliente, Long> {
}
