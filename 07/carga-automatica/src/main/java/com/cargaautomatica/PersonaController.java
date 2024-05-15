package com.cargaautomatica;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {

    @Value("${miapp.mensaje}")
    private String mensaje;

    @GetMapping
    public Persona home(){
        System.out.println("El valor de mensaje es: "+ mensaje);
        Persona p = new Persona();
        p.setNombre("Elivar");
        p.setApellido("Largo");
        p.setEdad(25);
        return p;
    }
}
