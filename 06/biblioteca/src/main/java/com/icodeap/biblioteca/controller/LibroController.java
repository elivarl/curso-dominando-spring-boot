package com.icodeap.biblioteca.controller;

import com.icodeap.biblioteca.entity.Libro;
import com.icodeap.biblioteca.service.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {
    private LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    //POST
    // http://localhost:8080/api/libros
    @PostMapping
    public ResponseEntity<Libro> save (@RequestBody Libro libro){
        return new ResponseEntity<>( libroService.save(libro), HttpStatus.CREATED);
    }

    //GET
    // http://localhost:8080/api/libros
    @GetMapping
    public ResponseEntity<List<Libro>> findAll(){
        return new ResponseEntity<>( libroService.findAll(),HttpStatus.OK);
    }

    //GET
    // http://localhost:8080/api/libros/2
    @GetMapping("/{idlibro}")
    public ResponseEntity< Libro> findById(@PathVariable("idlibro") Integer id){
        return new ResponseEntity<>( libroService.findById(id), HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Integer id){
        libroService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //PUT
    @PutMapping
    public ResponseEntity<Libro> update(@RequestBody Libro libro ){
        Libro libroDB = libroService.findById(libro.getId());
        libroDB.setIsbn(libro.getIsbn());
        libroDB.setNombre(libro.getNombre());
        libroDB.setEditorial(libro.getEditorial());
        libroDB.setGenero(libro.getGenero());
        libroDB.setPrecio(libro.getPrecio());
        libroDB.setFechEdicion(libro.getFechEdicion());
        return new ResponseEntity<> (libroService.update(libroDB), HttpStatus.OK);
    }

}
