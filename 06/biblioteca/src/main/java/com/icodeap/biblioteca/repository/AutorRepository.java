package com.icodeap.biblioteca.repository;

import com.icodeap.biblioteca.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor,Integer> {
    Optional<Autor> findByEmail(String email);
}
