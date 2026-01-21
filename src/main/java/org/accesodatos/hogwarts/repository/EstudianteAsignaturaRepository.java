package org.accesodatos.hogwarts.repository;

import org.accesodatos.hogwarts.model.EstudianteAsignatura;
import org.accesodatos.hogwarts.model.EstudianteAsignaturaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteAsignaturaRepository extends JpaRepository<EstudianteAsignatura, EstudianteAsignaturaId> {
}
