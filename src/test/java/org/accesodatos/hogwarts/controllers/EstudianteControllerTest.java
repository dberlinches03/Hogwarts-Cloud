package org.accesodatos.hogwarts.controllers;

import org.accesodatos.hogwarts.controller.StudentController;
import org.accesodatos.hogwarts.dto.request.create.EstudianteCreateDTO;
import org.accesodatos.hogwarts.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
public class EstudianteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private StudentService estudianteService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void crearEstudiante_AnyoCursoInvalido_DebeRetornar400() throws Exception {
        // GIVEN
        EstudianteCreateDTO dto = new EstudianteCreateDTO();
        dto.setNombre("Harry");
        dto.setApellido("Potter");
        dto.setAnyoCurso(10); // Valor inválido

        // WHEN & THEN
        mockMvc.perform(post("/api/estudiantes")
                        .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest());
        // El servicio NO debe ser llamado
        verify(estudianteService, never()).create(any());
    }
}
