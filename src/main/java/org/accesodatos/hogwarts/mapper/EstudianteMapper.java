package org.accesodatos.hogwarts.mapper;

import org.accesodatos.hogwarts.dto.AsignaturaCalificacionDTO;
import org.accesodatos.hogwarts.dto.EstudianteDTO;
import org.accesodatos.hogwarts.dto.MascotaDTO;
import org.accesodatos.hogwarts.model.Student;

import java.util.List;
import java.util.stream.Collectors;

public class EstudianteMapper {

    public static EstudianteDTO toDto(Student estudiante) {
        EstudianteDTO dto = new EstudianteDTO();
        dto.setId(estudiante.getIdEstudiante());
        dto.setNombre(estudiante.getNombre() + " " + estudiante.getApellido());
        dto.setAnyoCurso(estudiante.getAnyoCurso());
        dto.setFechaNacimiento(estudiante.getFechaNacimiento());

        if (estudiante.getCasa() != null) {
            dto.setCasa(estudiante.getCasa().getNombre());
        }

        MascotaDTO mascotaDTO = MascotaMapper.toDto(estudiante.getMascota());
        dto.setMascota(mascotaDTO);

        List<AsignaturaCalificacionDTO> asignaturas = estudiante.getEstudianteAsignaturas()
                .stream()
                .map(AsignaturaCalificacionMapper::toDto)
                .collect(Collectors.toList());
        dto.setAsignaturas(asignaturas);

        return dto;
    }
}
