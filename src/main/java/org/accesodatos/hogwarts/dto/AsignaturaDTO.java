package org.accesodatos.hogwarts.dto;

public class AsignaturaDTO {

    private Long id;
    private String nombre;
    private String aula;
    private Boolean obligatoria;
    private String profesor; // nombre completo

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getAula() { return aula; }
    public Boolean getObligatoria() { return obligatoria; }
    public String getProfesor() { return profesor; }

    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setAula(String aula) { this.aula = aula; }
    public void setObligatoria(Boolean obligatoria) { this.obligatoria = obligatoria; }
    public void setProfesor(String profesor) { this.profesor = profesor; }
}
