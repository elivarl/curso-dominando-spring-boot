package com.icodeap.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductoRepository extends JpaRepository<Producto,Integer> {
    //Query Methods
    Producto findByNombre(String nombre);
    List<Producto> findByCategoria(String categoria);
    List<Producto> findByStockAndPrecio(Integer stock, Double precio);
    List<Producto> findByOrderByPrecioAsc();
    //Consultas JPQL
    @Query("SELECT p FROM Producto p WHERE p.nombre = :nombre")
    Producto buscarProductoPorNombre(@Param("nombre") String nombre);
    @Query("SELECT p FROM Producto p WHERE p.categoria = :categoria")
    List<Producto> buscarProductoPorCategoria(@Param("categoria")String categoria);

    @Query("SELECT p FROM Producto p WHERE p.precio > :precio")
    List<Producto> buscarPorPrecioMayorQue(@Param("precio") Double precio);
}
