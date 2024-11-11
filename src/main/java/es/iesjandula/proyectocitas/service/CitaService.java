package es.iesjandula.proyectocitas.service;

import es.iesjandula.proyectocitas.model.Cita;
import es.iesjandula.proyectocitas.model.Empleado;
import es.iesjandula.proyectocitas.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    //Obtener todas las citas
    public List<Cita> obtenerTodascitas(){
        return citaRepository.findAll();
    }

    // Obtener una cita por su id
    public Optional<Cita> getCitaById(Long id) {
        return citaRepository.findById(id);
    }

    //Crear una cita
    public Cita guardarCita(Cita cita){
        return citaRepository.save(cita);
    }

    // Actualizar una cita existente
    public Cita actualizarCita(Long id, Cita citaDetails) {
        return citaRepository.findById(id)
                .map(cita -> {
                    // Actualiza los campos de la cita según los datos de `citaDetails`
                    cita.setId_Cita(citaDetails.getId_Cita());
                    cita.setId_Cliente(citaDetails.getId_Cliente());
                    cita.setId_Empleado(citaDetails.getId_Empleado());
                    cita.setId_Servicio(citaDetails.getId_Servicio());
                    cita.setFecha_hora_Cita(citaDetails.getFecha_hora_Cita());
                    cita.setObservaciones(citaDetails.getObservaciones());
                    cita.setEstado_Cita(citaDetails.getEstado_Cita());
                   //Muestra el resultado de la cita actualizada
                    return citaRepository.save(cita);
                })
                .orElseGet(() -> {
                    // Si no existe, guarda la cita con el ID proporcionado
                    citaDetails.setId_Cita(id);
                    return citaRepository.save(citaDetails);
                });
    }

    //Eliminar cita
    public void eliminarCita(Long id){

        citaRepository.deleteById(id);
    }


}
