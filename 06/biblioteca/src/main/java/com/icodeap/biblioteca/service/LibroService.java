package com.icodeap.biblioteca.service;

import com.icodeap.biblioteca.entity.Libro;

import java.util.List;

public interface LibroService {
    public Libro save(Libro libro);
    public List<Libro> findAll();
    public Libro findById(Integer id);
    public Libro update (Libro libro);
    public void delete(Integer id);
}
