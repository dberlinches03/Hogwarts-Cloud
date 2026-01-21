package org.accesodatos.hogwarts.repository;

import org.accesodatos.hogwarts.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
