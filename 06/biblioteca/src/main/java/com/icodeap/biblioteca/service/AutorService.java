package com.icodeap.biblioteca.service;

import com.icodeap.biblioteca.entity.Autor;
import com.icodeap.biblioteca.exception.EmailDuplicateException;
import com.icodeap.biblioteca.exception.ResourceNotFoundException;
import com.icodeap.biblioteca.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    //metodo para crear autores
    public Autor save(Autor autor){
        Optional<Autor> autorDB = autorRepository.findByEmail(autor.getEmail());
        if(autorDB.isPresent()){
            throw new EmailDuplicateException("Email",autor.getEmail());
        }
        return autorRepository.save(autor);
    }

    //retornar todos los objetos autor
    public List<Autor> findAll(){
        return autorRepository.findAll();
    }
    // obtenemos un autor por ID
    public Autor findById(Integer id){
        ///return autorRepository.findById(id).get();
        Autor autor = autorRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Autor", "id",id)
        );
        return autor;
    }
    // actualizar autor
    public Autor update (Autor autor){
        return autorRepository.save(autor);
    }

    //eliminar un objeto por ID
    public void delete(Integer id){
        Autor autor = autorRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Autor", "id",id)
        );
        autorRepository.deleteById(id);
    }
}
