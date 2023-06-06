package com.example.libreriaDos.repository;

import com.example.libreriaDos.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria,Long> {
    boolean existsByNombre (String valNombre);
}
