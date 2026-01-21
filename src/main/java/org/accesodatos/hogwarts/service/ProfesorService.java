package org.accesodatos.hogwarts.service;

import org.accesodatos.hogwarts.dto.ProfesorDTO;
import org.accesodatos.hogwarts.mapper.ProfesorMapper;
import org.accesodatos.hogwarts.repository.ProfesorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfesorService {

    private final ProfesorRepository repo;

    public ProfesorService(ProfesorRepository repo) {
        this.repo = repo;
    }

    public List<ProfesorDTO> findAll() {
        return repo.findAll()
                .stream()
                .map(ProfesorMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<ProfesorDTO> findById(Long id) {
        return repo.findById(id)
                .map(ProfesorMapper::toDto);
    }
}
