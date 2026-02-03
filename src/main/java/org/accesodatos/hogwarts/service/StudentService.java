package org.accesodatos.hogwarts.service;

import org.accesodatos.hogwarts.dto.response.EstudianteDTO;
import org.accesodatos.hogwarts.mapper.EstudianteMapper;
import org.accesodatos.hogwarts.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<EstudianteDTO> findAll() {
        return repo.findAll()
                .stream()
                .map(EstudianteMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<EstudianteDTO> findById(Long id) {
        return repo.findById(id)
                .map(EstudianteMapper::toDto);
    }
}
