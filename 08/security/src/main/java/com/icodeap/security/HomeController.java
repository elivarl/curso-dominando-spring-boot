package com.icodeap.security;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/security")
public class HomeController {

    @GetMapping
    public String hello(){
        return "Welcome Spring Security";
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto){
        System.out.println("El nombre del producto es");
        System.out.println(producto.getNombre());
        return producto;
    }
}
