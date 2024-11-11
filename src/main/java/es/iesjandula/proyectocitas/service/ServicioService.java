package es.iesjandula.proyectocitas.service;

import es.iesjandula.proyectocitas.model.Servicio;
import es.iesjandula.proyectocitas.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    //Obtener todas los servicios
    public List<Servicio> obtenerTodosServicios() {
        return servicioRepository.findAll();
    }

    // Obtener un servicio por su id
    public Optional<Servicio> getServicioById(Long id) {
        return servicioRepository.findById(id);
    }

    //Crear un servicio
    public Servicio guardarServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    //Actualizar un servicio existente

    public Servicio actualizarServicio(Long idServicio, Servicio servicioDetails) {
        return servicioRepository.findById(idServicio)
                .map(servicio -> {
                    // Actualiza los campos de la cita según los datos de `citaDetails`
                    servicio.setIdServicio(servicioDetails.getIdServicio());
                    servicio.setNombre(servicioDetails.getNombre());
                    servicio.setDescripcion(servicioDetails.getDescripcion());
                    servicio.setDuracion(servicioDetails.getDuracion());

                    //Muestra el resultado de la cita actualizada
                    return servicioRepository.save(servicio);
                })
                .orElseGet(() -> {
                    // Si no existe, guarda la cita con el ID proporcionado
                    servicioDetails.setIdServicio(idServicio);
                    return servicioRepository.save(servicioDetails);
                });
    }

    //Eliminar servicio
    public void eliminarServicio(Long idServicio) {

        servicioRepository.deleteById(idServicio);

    }
}
