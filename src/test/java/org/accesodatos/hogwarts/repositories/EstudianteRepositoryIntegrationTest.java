package org.accesodatos.hogwarts.repositories;

import jakarta.persistence.EntityManager;
import org.accesodatos.hogwarts.model.Mascota;
import org.accesodatos.hogwarts.model.Student;
import org.accesodatos.hogwarts.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest // Configura una BD en memoria y carga solo entidades y repositorios
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@ActiveProfiles("test")
public class EstudianteRepositoryIntegrationTest {

    @Autowired
    private StudentRepository estudianteRepository;

    @Autowired
    private EntityManager entityManager; // Usamos el motor de JPA para consultas directas


    @Test
    void eliminarEstudiante_DebeEliminarMascotaEnCascada() {
        // 1. GIVEN: Preparamos los datos
        Student estudiante = new Student();
        estudiante.setNombre("Harry");
        estudiante.setApellido("Potter");

        Mascota mascota = new Mascota();
        mascota.setNombre("Hedwig");
        mascota.setEspecie("Lechuza");
        
        estudiante.setMascota(mascota); // Sincronizamos la relación bidireccional

        // Persistimos el estudiante (y por cascada, la mascota)
        Student guardado = estudianteRepository.save(estudiante);
        Long idEstudiante = guardado.getIdEstudiante();
        Long idMascota = guardado.getMascota().getIdMascota();

        // 2. WHEN: Ejecutamos la acción de borrado
        estudianteRepository.delete(guardado);
        estudianteRepository.flush();
        entityManager.clear();

       // 3. THEN
        Student estudianteBD = entityManager.find(Student.class, idEstudiante);
        Mascota mascotaBD = entityManager.find(Mascota.class, idMascota);

        assertNull(estudianteBD);
        assertNull(mascotaBD);

        // Ambos siguen existiendo físicamente, pero con deleted = true
        Boolean deletedEstudiante = (Boolean) entityManager
                .createNativeQuery("SELECT deleted FROM estudiante WHERE id_estudiante = ?")
                .setParameter(1, idEstudiante)
                .getSingleResult();
        Boolean deletedMascota = (Boolean) entityManager
                .createNativeQuery("SELECT deleted FROM Mascota WHERE id_mascota = ?")
                .setParameter(1, idMascota)
                .getSingleResult();

        assertTrue(deletedEstudiante);
        assertTrue(deletedMascota);
    }
}
