package com.icodeap.biblioteca.controller;

import com.icodeap.biblioteca.entity.Autor;
import com.icodeap.biblioteca.exception.ErrorResponse;
import com.icodeap.biblioteca.exception.ResourceNotFoundException;
import com.icodeap.biblioteca.service.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    private AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    //POST
    //http:localhost:8080/api/autores
    @PostMapping
    public ResponseEntity<Autor> save(@RequestBody Autor autor){
        return new ResponseEntity<>(autorService.save(autor), HttpStatus.CREATED)  ;
    }

    //GET
    //http:localhost:8080/api/autores
    @GetMapping
    public ResponseEntity<List<Autor>> findAll(){
        return new ResponseEntity<>(autorService.findAll(), HttpStatus.OK) ;
    }
    //GET
    //http:localhost:8080/api/autores/5
    @GetMapping("/{id}")
    public ResponseEntity<Autor> findById(@PathVariable Integer id){
       return  new ResponseEntity<>(autorService.findById(id), HttpStatus.OK);
    }
    //DELETE
    //http:localhost:8080/api/autores/5
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id){
        autorService.delete(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    //PUT
    //http:localhost:8080/api/autores
    @PutMapping
    public ResponseEntity <Autor> update(@RequestBody Autor autor){
        Autor autorDb = autorService.findById(autor.getId());
        autorDb.setNombres(autor.getNombres());
        autorDb.setApellidos(autor.getApellidos());
        autorDb.setEmail(autor.getEmail());
        autorDb.setTelefono(autor.getTelefono());
        //autorDb.setLibros(autorDb.getLibros());
        return  new ResponseEntity<>( autorService.update(autorDb), HttpStatus.OK);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                         WebRequest webRequest
                                                                         ){
        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "AUTOR_NOT_FOUND"
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
