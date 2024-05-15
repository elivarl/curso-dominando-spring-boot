package com.icodeap.security;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/private/productos")
@RequestMapping("/api/admin/productos")
public class CrearProductoController {
    @PostMapping
    public Producto createProducto(@RequestBody Producto producto){
        System.out.println("El nombre del producto es");
        System.out.println(producto.getNombre());
        return producto;
    }
}
