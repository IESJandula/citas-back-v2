package es.iesjandula.proyectocitas.service;

import es.iesjandula.proyectocitas.model.Horario;
import es.iesjandula.proyectocitas.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    //Obtener todos los horarios
    public List<Horario> obtenerHorarios(){
        return horarioRepository.findAll();
    }

    //Guardar un nuevo horario
    public Horario guardarHorario(Horario horario){
        return horarioRepository.save(horario);
    }

    //Actualizar horario existente
    public Horario actualizarHorario(Long id, Horario horarioActualizado){
        return horarioRepository.findById(id).map(horario -> {
            horario.setHoraInicio(horarioActualizado.getHoraInicio());
            horario.setHoraFin(horarioActualizado.getHoraFin());
            return horarioRepository.save(horario);
        }).orElseThrow(() -> new RuntimeException("Horario no encontrado"));
    }

    //Eliminar horario
    public void eliminarHorario(Long id){
        horarioRepository.deleteById(id);
    }
}
