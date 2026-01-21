package org.accesodatos.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "Mascota")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private Long idMascota;

    @Column(name = "nombre_mascota", nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String especie;

    @OneToOne
    @JoinColumn(name = "id_estudiante")
    @JsonBackReference
    private Student estudiante;

    // Getters y setters
    public Long getIdMascota() { return idMascota; }
    public String getNombre() { return nombre; }
    public String getEspecie() { return especie; }
    public Student getEstudiante() { return estudiante; }

    public void setIdMascota(Long idMascota) { this.idMascota = idMascota; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEspecie(String especie) { this.especie = especie; }
    public void setEstudiante(Student estudiante) { this.estudiante = estudiante; }
}
