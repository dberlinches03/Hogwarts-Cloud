package org.accesodatos.hogwarts.dto;

import java.time.LocalDate;
import java.util.List;

public class EstudianteDTO {

    private Long id;
    private String nombre; // nombre + apellido
    private int anyoCurso;
    private LocalDate fechaNacimiento;
    private String casa;
    private MascotaDTO mascota;
    private List<AsignaturaCalificacionDTO> asignaturas;

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public int getAnyoCurso() { return anyoCurso; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public String getCasa() { return casa; }
    public MascotaDTO getMascota() { return mascota; }
    public List<AsignaturaCalificacionDTO> getAsignaturas() { return asignaturas; }

    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setAnyoCurso(int anyoCurso) { this.anyoCurso = anyoCurso; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public void setCasa(String casa) { this.casa = casa; }
    public void setMascota(MascotaDTO mascota) { this.mascota = mascota; }
    public void setAsignaturas(List<AsignaturaCalificacionDTO> asignaturas) { this.asignaturas = asignaturas; }
}
