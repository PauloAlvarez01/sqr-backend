package com.sanatorio.sqrbackend.services;

import com.sanatorio.sqrbackend.entities.Paciente;
import com.sanatorio.sqrbackend.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> obtenerTodos() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> obtenerPorId(Integer id) {
        return pacienteRepository.findById(id);
    }

    public Paciente crear(Paciente entidad) {
        // Validación de negocio: No permitir DNI duplicados
        if (pacienteRepository.existsByDni(entidad.getDni())) {
            throw new IllegalArgumentException("Ya existe un paciente registrado con el DNI: " + entidad.getDni());
        }
        return pacienteRepository.save(entidad);
    }

    public Paciente actualizar(Integer id, Paciente entidadActualizada) {
        Paciente entidadExistente = pacienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El paciente con ID " + id + " no existe"));

        // Si intentan cambiar el DNI, verificamos que el nuevo no pertenezca a otro paciente
        if (!entidadExistente.getDni().equals(entidadActualizada.getDni()) &&
                pacienteRepository.existsByDni(entidadActualizada.getDni())) {
            throw new IllegalArgumentException("El nuevo DNI ingresado ya pertenece a otro paciente registrado");
        }

        entidadExistente.setApellidoPaciente(entidadActualizada.getApellidoPaciente());
        entidadExistente.setNombrePaciente(entidadActualizada.getNombrePaciente());
        entidadExistente.setSexoPaciente(entidadActualizada.getSexoPaciente());
        entidadExistente.setDni(entidadActualizada.getDni());
        entidadExistente.setTelefonoPaciente(entidadActualizada.getTelefonoPaciente());
        entidadExistente.setEmailPaciente(entidadActualizada.getEmailPaciente());
        entidadExistente.setFechaNacimientoPaciente(entidadActualizada.getFechaNacimientoPaciente());

        return pacienteRepository.save(entidadExistente);
    }

    public void eliminar(Integer id) {
        if (!pacienteRepository.existsById(id)) {
            throw new IllegalArgumentException("El paciente con ID " + id + " no existe");
        }
        pacienteRepository.deleteById(id);
    }

    // --- MÉTODOS DE BÚSQUEDA INTELIGENTE PARA EL FRONTEND ---

    /**
     * Busca un paciente por su DNI exacto.
     * Ideal para cuando el administrativo tiene el documento en la mano.
     */
    public Optional<Paciente> buscarPorDni(String dni) {
        return pacienteRepository.findByDni(dni);
    }

    /**
     * Busca pacientes cuyo apellido contenga la cadena enviada.
     * Ignora mayúsculas y minúsculas. Ideal para buscadores predictivos.
     */
    public List<Paciente> buscarPorApellido(String apellido) {
        return pacienteRepository.findByApellidoPacienteContainingIgnoreCase(apellido);
    }

    /**
     * Búsqueda refinada por Apellido y Nombre.
     * Útil para filtrar cuando hay apellidos muy comunes (ej: "García").
     */
    public List<Paciente> buscarPorApellidoYNombre(String apellido, String nombre) {
        return pacienteRepository.findByApellidoPacienteContainingIgnoreCaseAndNombrePacienteContainingIgnoreCase(apellido, nombre);
    }
}
