package com.icodeap.persistencia;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    private ProductoRepository productRepository;

    public ProductoService(ProductoRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Producto save(Producto producto){
        return productRepository.save(producto);
    }
    public List<Producto> findAll(){
        return productRepository.findAll();
    }

    public Producto finById(Integer id){
        return productRepository.findById(id).get();
    }
    public void deleteById(Integer id){
        productRepository.deleteById(id);
    }

    public Producto findByNombre (String nombre){
        return productRepository.findByNombre(nombre);
    }

    public List<Producto> findByCategoria(String categoria){
        return productRepository.findByCategoria(categoria);
    }

    public List<Producto> findByStockAndPrecio(Integer stock, Double precio){
        return productRepository.findByStockAndPrecio(stock, precio);
    }

    public List<Producto> findByOrderByPrecioAsc(){
        return productRepository.findByOrderByPrecioAsc();
    }
    //Consultas JPQL
    public Producto buscarProductoPorNombre(String nombre){
        return productRepository.buscarProductoPorNombre(nombre);
    }

    public List<Producto> buscarProductoPorCategoria(String categoria){
        return productRepository.buscarProductoPorCategoria(categoria);
    }

    public List<Producto> buscarPorPrecioMayorQue(Double precio){
        return productRepository.buscarPorPrecioMayorQue(precio);
    }
}
