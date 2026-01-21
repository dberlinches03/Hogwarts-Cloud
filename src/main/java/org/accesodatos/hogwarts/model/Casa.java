package org.accesodatos.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Casa")
public class Casa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_casa")
    private Long idCasa;

    @Column(name = "nombre_casa", nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String fundador;

    @Column(nullable = false)
    private String fantasma;

    @ManyToOne
    @JoinColumn(name = "id_jefe")
    @JsonBackReference
    private Profesor jefe;

    @OneToMany(mappedBy = "casa")
    @JsonManagedReference
    private List<Student> estudiantes;

    // Getters y setters
    public Long getIdCasa() { return idCasa; }
    public String getNombre() { return nombre; }
    public String getFundador() { return fundador; }
    public String getFantasma() { return fantasma; }
    public Profesor getJefe() { return jefe; }
    public List<Student> getEstudiantes() { return estudiantes; }

    public void setIdCasa(Long idCasa) { this.idCasa = idCasa; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setFundador(String fundador) { this.fundador = fundador; }
    public void setFantasma(String fantasma) { this.fantasma = fantasma; }
    public void setJefe(Profesor jefe) { this.jefe = jefe; }
    public void setEstudiantes(List<Student> estudiantes) { this.estudiantes = estudiantes; }
}
