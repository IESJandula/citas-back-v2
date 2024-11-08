package es.iesjandula.proyectocitas.service;

import es.iesjandula.proyectocitas.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.iesjandula.proyectocitas.repository.ClienteRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Crear un nuevo cliente
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Obtener todos los clientes
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    // Obtener un cliente por su ID
    public Optional<Cliente> obtenerClientePorId(Long idCliente) {
        return clienteRepository.findById(idCliente);
    }

    // Actualizar un cliente existente
    public Cliente actualizarCliente(Long idCliente, Cliente cliente) {
        if (clienteRepository.existsById(idCliente)) {
            cliente.setIdCliente(idCliente);
            return clienteRepository.save(cliente);
        }
        return null;  // O lanzar una excepción si no se encuentra el cliente
    }

    // Eliminar un cliente por su ID
    public boolean eliminarCliente(Long idCliente) {
        if (clienteRepository.existsById(idCliente)) {
            clienteRepository.deleteById(idCliente);
            return true;
        }
        return false;  // O lanzar una excepción si no se encuentra el cliente
    }
}
