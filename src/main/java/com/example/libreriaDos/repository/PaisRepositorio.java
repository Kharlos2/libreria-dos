package com.example.libreriaDos.repository;

import com.example.libreriaDos.entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepositorio extends JpaRepository<Pais,Long> {
}
