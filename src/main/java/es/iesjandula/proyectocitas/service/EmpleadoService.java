package es.iesjandula.proyectocitas.service;

import es.iesjandula.proyectocitas.model.Empleado;
import es.iesjandula.proyectocitas.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    //Obtener todos los empleados
    public List<Empleado> obtenerTodosLosEmpleados(){
        return empleadoRepository.findAll();
    }

    //Guardar empleado
    public Empleado guardarEmpleado(Empleado empleado){
        return empleadoRepository.save(empleado);
    }

    //Actualizar empleado
    public Empleado actualizarEmpleado(Long id, Empleado empleadoActualizado){
        return empleadoRepository.findById(id).map(empleado -> {
            empleado.setNombre(empleadoActualizado.getNombre());
            empleado.setHorario(empleadoActualizado.getHorario());
            return empleadoRepository.save(empleado);
        }).orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    }

    //EliminarEmpleado por id
    public void eliminarEmpleado(Long id){
        empleadoRepository.deleteById(id);
    }
}
