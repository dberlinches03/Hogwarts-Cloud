package org.accesodatos.hogwarts.service;

import org.accesodatos.hogwarts.dto.CasaDTO;
import org.accesodatos.hogwarts.mapper.CasaMapper;
import org.accesodatos.hogwarts.repository.CasaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CasaService {

    private final CasaRepository repo;

    public CasaService(CasaRepository repo) {
        this.repo = repo;
    }

    public List<CasaDTO> findAll() {
        return repo.findAll()
                .stream()
                .map(CasaMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<CasaDTO> findById(Long id) {
        return repo.findById(id)
                .map(CasaMapper::toDto);
    }
}
