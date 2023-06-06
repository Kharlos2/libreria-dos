package com.example.libreriaDos.repository;

import com.example.libreriaDos.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor,Long> {
    boolean existsByPseudonimo (String valPseudonimo);
    boolean existsByEmail (String valEmail);


}
