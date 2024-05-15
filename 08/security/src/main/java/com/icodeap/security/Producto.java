package com.icodeap.security;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Producto {
    private Integer id;
    private String nombre;
    private String codigo;
    private String descripcion;
}
