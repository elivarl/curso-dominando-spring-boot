package com.icodeap.apirest;

import org.springframework.web.bind.annotation.*;

@RestController
public class PersonaController {

    //POST
    //http://localhost:8080

    //http://localhost:8080/crear
    @PostMapping
    public String guardarPersona(@RequestBody Persona persona){
        System.out.println("El nombre de la persona es:");
        System.out.println(persona.getNombre());
        return "Persona guardada correctaente...";
    }

    ///PUT
    // http://localhost:8080
    @PutMapping
    public Persona actualizarPersona(@RequestBody Persona persona){
        Persona personaDB = new Persona();
        personaDB.setId(2);
        personaDB.setNombre("Elivar");
        personaDB.setEdad(30);

        //actualizando
        personaDB.setNombre(persona.getNombre());
        personaDB.setEdad(persona.getEdad());

        return personaDB;
    }

    //DELETE
    // http://localhost:8080/12
    @DeleteMapping("/{id}")
    public String eliminarPersona(@PathVariable Integer id){
        return "Persona con id: "+ id +" eliminado" ;
    }

}
