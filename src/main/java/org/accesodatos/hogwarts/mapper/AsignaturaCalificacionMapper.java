package org.accesodatos.hogwarts.mapper;

import org.accesodatos.hogwarts.dto.AsignaturaCalificacionDTO;
import org.accesodatos.hogwarts.model.EstudianteAsignatura;

public class AsignaturaCalificacionMapper {

    public static AsignaturaCalificacionDTO toDto(EstudianteAsignatura ea) {
        AsignaturaCalificacionDTO dto = new AsignaturaCalificacionDTO();
        dto.setCalificacion(ea.getCalificacion());
        if (ea.getAsignatura() != null) {
            dto.setAsignatura(ea.getAsignatura().getNombre());
        }
        return dto;
    }
}
