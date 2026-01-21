package org.accesodatos.hogwarts.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EstudianteAsignaturaId implements Serializable {

    @Column(name = "id_estudiante")
    private Long idEstudiante;

    @Column(name = "id_asignatura")
    private Long idAsignatura;

    public EstudianteAsignaturaId() {}

    public EstudianteAsignaturaId(Long idEstudiante, Long idAsignatura) {
        this.idEstudiante = idEstudiante;
        this.idAsignatura = idAsignatura;
    }

    // GETTERS
    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public Long getIdAsignatura() {
        return idAsignatura;
    }

    // SETTERS
    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public void setIdAsignatura(Long idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EstudianteAsignaturaId that)) return false;
        return Objects.equals(idEstudiante, that.idEstudiante)
                && Objects.equals(idAsignatura, that.idAsignatura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstudiante, idAsignatura);
    }
}
