package org.accesodatos.hogwarts.mapper;

import org.accesodatos.hogwarts.dto.ProfesorDTO;
import org.accesodatos.hogwarts.model.Profesor;

public class ProfesorMapper {

    public static ProfesorDTO toDto(Profesor profesor) {
        if (profesor == null) return null;

        ProfesorDTO dto = new ProfesorDTO();
        dto.setId(profesor.getIdProfesor());
        dto.setNombre(profesor.getNombre() + " " + profesor.getApellido());
        if (profesor.getAsignatura() != null) {
            dto.setAsignatura(profesor.getAsignatura().getNombre());
        }
        dto.setFechaInicio(profesor.getFechaInicio());
        return dto;
    }
}
