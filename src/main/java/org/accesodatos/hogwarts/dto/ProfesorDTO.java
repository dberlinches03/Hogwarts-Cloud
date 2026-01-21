package org.accesodatos.hogwarts.dto;

import java.time.LocalDate;

public class ProfesorDTO {

    private Long id;
    private String nombre;      // nombre + apellido
    private String asignatura;  // nombre asignatura
    private LocalDate fechaInicio;

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getAsignatura() { return asignatura; }
    public LocalDate getFechaInicio() { return fechaInicio; }

    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setAsignatura(String asignatura) { this.asignatura = asignatura; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
}
