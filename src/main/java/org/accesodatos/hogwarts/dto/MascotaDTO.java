package org.accesodatos.hogwarts.dto;

public class MascotaDTO {

    private Long id;
    private String nombre;
    private String especie;
    private String estudiante; // nombre completo

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEspecie() { return especie; }
    public String getEstudiante() { return estudiante; }

    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEspecie(String especie) { this.especie = especie; }
    public void setEstudiante(String estudiante) { this.estudiante = estudiante; }
}
