package com.icodeap.biblioteca.service;

import com.icodeap.biblioteca.entity.Libro;
import com.icodeap.biblioteca.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl implements LibroService{
    private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    @Override
    public Libro findById(Integer id) {
        return libroRepository.findById(id).get();
    }

    @Override
    public Libro update(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public void delete(Integer id) {
        libroRepository.deleteById(id);
    }
}
