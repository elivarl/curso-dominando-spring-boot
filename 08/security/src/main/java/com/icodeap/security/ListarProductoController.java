package com.icodeap.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/api/public/productos")
@RequestMapping("/api/user/productos")
public class ListarProductoController {

    @GetMapping
    public List<Producto> getProducts(){
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1, "001", "televisor","Televisor 21 pulgadas"));
        productos.add(new Producto(2, "002", "monitor","monitor 27 pulgadas"));
        productos.add(new Producto(3, "003", "teclado","teclado"));
        return productos;
    }
}
