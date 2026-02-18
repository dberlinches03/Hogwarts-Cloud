package org.accesodatos.hogwarts.service;

import org.accesodatos.hogwarts.dto.AsignaturaDTO;
import org.accesodatos.hogwarts.mapper.AsignaturaMapper;
import org.accesodatos.hogwarts.repository.AsignaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AsignaturaService {

    private final AsignaturaRepository repo;

    public AsignaturaService(AsignaturaRepository repo) {
        this.repo = repo;
    }

    public List<AsignaturaDTO> findAll() {
        return repo.findAll()
                .stream()
                .map(AsignaturaMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<AsignaturaDTO> findById(Long id) {
        return repo.findById(id)
                .map(AsignaturaMapper::toDto);
    }

    public void eliminarAsignatura(Long id) {
        var asignatura = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Asignatura no encontrada"));
        // Si tiene alumnos, no se puede eliminar
        if (!asignatura.getEstudianteAsignaturas().isEmpty()) {
            throw new IllegalStateException("La asignatura tiene alumnos y no puede eliminarse ");
        }

        repo.delete(asignatura);
    }
}
