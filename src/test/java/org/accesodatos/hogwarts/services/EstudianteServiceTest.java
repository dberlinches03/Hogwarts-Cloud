package org.accesodatos.hogwarts.services;

import org.accesodatos.hogwarts.model.Mascota;
import org.accesodatos.hogwarts.model.Student;
import org.accesodatos.hogwarts.repository.MascotaRepository;
import org.accesodatos.hogwarts.repository.StudentRepository;
import org.accesodatos.hogwarts.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Para inicializar Mockito sin cargar Spring
public class EstudianteServiceTest {

    @Mock
    private StudentRepository estudianteRepository;

    @Mock
    private MascotaRepository mascotaRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    private Student estudianteTest;

    @BeforeEach
    void setUp() {
        estudianteTest = new Student();
        estudianteTest.setIdEstudiante(1L);
        estudianteTest.setNombre("Harry");
        estudianteTest.setApellido("Potter");
        estudianteTest.setMascota(new Mascota());
    }

    @Test
    void eliminarEstudiante_Exito() {
        // GIVEN (Preparación del escenario)
        Long id = 1L;
        // Simulamos que el usuario existe
        when(estudianteRepository.findById(id)).thenReturn(Optional.of(estudianteTest));

        // WHEN (Ejecución)
        studentService.eliminarEstudiante(id);

        // THEN (Verificación)

        // Verificamos que se llamó al método delete del repositorio una vez
        verify(mascotaRepository, times(1)).delete(estudianteTest.getMascota());
        verify(estudianteRepository, times(1)).delete(estudianteTest);
    }
}
