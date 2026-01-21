package org.accesodatos.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Estudiante")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Long idEstudiante;

    private String nombre;
    private String apellido;

    @Column(name = "anyo_curso")
    private int anyoCurso;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    // ManyToOne con Casa
    @ManyToOne
    @JoinColumn(name = "id_casa")
    @JsonBackReference
    private Casa casa;

    // OneToOne con Mascota
    @OneToOne(mappedBy = "estudiante", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Mascota mascota;

    // N-N con Asignatura mediante EstudianteAsignatura
    @OneToMany(mappedBy = "estudiante")
    @JsonManagedReference
    private List<EstudianteAsignatura> estudianteAsignaturas;

    // Getters y setters
    public Long getIdEstudiante() { return idEstudiante; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public int getAnyoCurso() { return anyoCurso; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public Casa getCasa() { return casa; }
    public Mascota getMascota() { return mascota; }
    public List<EstudianteAsignatura> getEstudianteAsignaturas() { return estudianteAsignaturas; }

    public void setIdEstudiante(Long idEstudiante) { this.idEstudiante = idEstudiante; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setAnyoCurso(int anyoCurso) { this.anyoCurso = anyoCurso; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public void setCasa(Casa casa) { this.casa = casa; }
    public void setMascota(Mascota mascota) { this.mascota = mascota; }
    public void setEstudianteAsignaturas(List<EstudianteAsignatura> estudianteAsignaturas) { this.estudianteAsignaturas = estudianteAsignaturas; }
}
