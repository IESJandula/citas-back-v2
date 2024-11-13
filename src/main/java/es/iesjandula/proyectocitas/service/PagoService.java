package es.iesjandula.proyectocitas.service;

import es.iesjandula.proyectocitas.model.Cita;
import es.iesjandula.proyectocitas.model.Pago;
import es.iesjandula.proyectocitas.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoService {
    @Autowired
    private PagoRepository pagoRepository;

    //Obtener todos los pagos
    public List<Pago> obtenerTodosPagos() {
        return pagoRepository.findAll();
    }

    // Obtener un pago por su id
    public Optional<Pago> getPagoById(Long id) {
        return pagoRepository.findById(id);
    }

    //Crear un pago
    public Pago guardarPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    //Actualizar un pago
    public Pago actualizarPago(Long idPago, Pago pagoDetails) {
        return pagoRepository.findById(idPago)
                .map(pago -> {
                    // Actualiza los campos de la cita según los datos de `citaDetails`
                    pago.setIdPago(pagoDetails.getIdPago());
                    pago.setFechaPago(pagoDetails.getFechaPago());
                    pago.setMetodoPago(pagoDetails.getMetodoPago());
                    pago.setMonto(pagoDetails.getMonto());

                    //Muestra el resultado de la cita actualizada
                    return pagoRepository.save(pago);
                })
                .orElseGet(() -> {
                    // Si no existe, guarda la cita con el ID proporcionado
                    pagoDetails.setIdPago(idPago);
                    return pagoRepository.save(pagoDetails);
                });
    }

    //Eliminar pago
    public void eliminarPago(Long id){

        pagoRepository.deleteById(id);
    }
}
