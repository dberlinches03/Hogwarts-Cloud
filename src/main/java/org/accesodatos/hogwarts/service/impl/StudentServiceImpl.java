package org.accesodatos.hogwarts.service.impl;

import org.accesodatos.hogwarts.dto.request.create.EstudianteCreateDTO;
import org.accesodatos.hogwarts.dto.request.update.EstudianteUpdateDTO;
import org.accesodatos.hogwarts.dto.response.EstudianteDTO;
import org.accesodatos.hogwarts.mapper.EstudianteMapper;
import org.accesodatos.hogwarts.model.Casa;
import org.accesodatos.hogwarts.model.Mascota;
import org.accesodatos.hogwarts.model.Student;
import org.accesodatos.hogwarts.repository.CasaRepository;
import org.accesodatos.hogwarts.repository.MascotaRepository;
import org.accesodatos.hogwarts.repository.StudentRepository;
import org.accesodatos.hogwarts.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final CasaRepository casaRepository;
    private final MascotaRepository mascotaRepository;
    private final EstudianteMapper mapper = new EstudianteMapper();

    public StudentServiceImpl(StudentRepository studentRepo, CasaRepository casaRepo, MascotaRepository mascotaRepo) {
        this.studentRepository = studentRepo;
        this.casaRepository = casaRepo;
        this.mascotaRepository = mascotaRepo;
    }
    @Override
    public EstudianteDTO create(EstudianteCreateDTO dto) {
        Casa casa = casaRepository.findById(dto.getCasaId())
                .orElseThrow(() -> new IllegalArgumentException("Casa no encontrada"));
        Student estudiante = mapper.toEntity(dto, casa);
        estudiante = studentRepository.save(estudiante);

        if (dto.getMascota() != null) {
            Mascota mascota = mapper.toMascotaEntity(dto.getMascota(), estudiante);
            mascota = mascotaRepository.save(mascota);
            estudiante.setMascota(mascota);
            estudiante = studentRepository.save(estudiante);
        }
        return mapper.toDto(estudiante);
    }
    @Override
    public EstudianteDTO update(Long id, EstudianteUpdateDTO dto) {
        Student estudiante = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Estudiante no encontrado"));
        mapper.updateEntity(estudiante, dto);
        estudiante = studentRepository.save(estudiante);

        if (dto.getMascota() == null) {
            if (estudiante.getMascota() != null) {
                mascotaRepository.delete(estudiante.getMascota());
                estudiante.setMascota(null);
                studentRepository.save(estudiante);
            }
        } else {
            if (estudiante.getMascota() == null) {
                Mascota nueva = mapper.toMascotaEntity(dto.getMascota(), estudiante);
                nueva = mascotaRepository.save(nueva);
                estudiante.setMascota(nueva);
                studentRepository.save(estudiante);
            } else {
                mapper.updateMascota(estudiante.getMascota(), dto.getMascota());
                mascotaRepository.save(estudiante.getMascota());
            }
        }
        return mapper.toDto(estudiante);
    }
}
