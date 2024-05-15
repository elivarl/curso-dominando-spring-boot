package com.icodeap.apirest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String saludar(){
        return "Hola desde Spring Boot....";
    }

    @GetMapping("/despedir")
    public String despedir(){
        return "Adios desde Spring Boot..";
    }

}
