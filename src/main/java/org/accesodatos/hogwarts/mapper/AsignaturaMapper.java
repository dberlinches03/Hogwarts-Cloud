package org.accesodatos.hogwarts.mapper;

import org.accesodatos.hogwarts.dto.AsignaturaDTO;
import org.accesodatos.hogwarts.model.Asignatura;
import org.accesodatos.hogwarts.model.Profesor;

public class AsignaturaMapper {

    public static AsignaturaDTO toDto(Asignatura asignatura) {
        AsignaturaDTO dto = new AsignaturaDTO();
        dto.setId(asignatura.getIdAsignatura());
        dto.setNombre(asignatura.getNombre());
        dto.setAula(asignatura.getAula());
        dto.setObligatoria(asignatura.getObligatoria());

        Profesor profesorPrincipal = asignatura.getProfesores() != null && !asignatura.getProfesores().isEmpty()
                ? asignatura.getProfesores().get(0)
                : null;

        if (profesorPrincipal != null) {
            dto.setProfesor(profesorPrincipal.getNombre() + " " + profesorPrincipal.getApellido());
        }

        return dto;
    }
}
