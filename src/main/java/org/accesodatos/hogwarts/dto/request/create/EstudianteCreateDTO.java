package org.accesodatos.hogwarts.dto.request.create;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EstudianteCreateDTO {

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;


    @Max(7)
    @Min(1)
    private int anyoCurso;
    private LocalDate fechaNacimiento;
    private Long casaId;
    private MascotaCreateDTO mascota;
}
