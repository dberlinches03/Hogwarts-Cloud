package org.accesodatos.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Asignatura")
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignatura") private Long idAsignatura;
    @Column(name = "nombre", nullable = false)
    private String nombre;

    private String aula;

    private Boolean obligatoria;

    @OneToMany(mappedBy = "asignatura")
    @JsonManagedReference
    private List<Profesor> profesores;

    @OneToMany(mappedBy = "asignatura")
    @JsonManagedReference
    private List<EstudianteAsignatura> estudianteAsignaturas;

    public Long getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Long idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public Boolean getObligatoria() {
        return obligatoria;
    }

    public void setObligatoria(Boolean obligatoria) {
        this.obligatoria = obligatoria;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    public List<EstudianteAsignatura> getEstudianteAsignaturas() {
        return estudianteAsignaturas;
    }

    public void setEstudianteAsignaturas(List<EstudianteAsignatura> estudianteAsignaturas) {
        this.estudianteAsignaturas = estudianteAsignaturas;
    }
}
