package com.icodeap.persistencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@SpringBootApplication
public class PersistenciaApplication implements CommandLineRunner {

	@Autowired
	private ProductoService productoService;

	public static void main(String[] args) {
		SpringApplication.run(PersistenciaApplication.class, args);

		/*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersistenciaApplication.class );

		ProductoService productoService = context.getBean(ProductoService.class);

		Producto producto = new Producto();
		producto.setNombre("Televisor1");
		producto.setCategoria("Electrodomesticos");
		producto.setPrecio(650.0);
		producto.setStock(50);

		///productoService.save(producto);
		productoService.deleteById(2);

		System.out.println("Busqueda de todos los registros:");
		//System.out.println(productoService.finById(1));
		productoService.findAll().forEach(
				p-> System.out.println(p)
		);*/
	}

	@Override
	public void run(String... args) throws Exception {
		Producto producto = new Producto();
		producto.setNombre("Mouse");
		producto.setCategoria("Tecnologia");
		producto.setPrecio(25.0);
		producto.setStock(100);

		System.out.println("Busqueda por id");
		System.out.println(productoService.finById(1));
		System.out.println("----------------------------------------------");


		//productoService.save(producto);
		System.out.println("Busqueda de todos los registros:");
		//System.out.println(productoService.finById(1));
		productoService.findAll().forEach(
				p-> System.out.println(p)
		);
		System.out.println("-----------------Query Methods--------------------------------");
		System.out.println("Busqueda por nombre");
		System.out.println(productoService.findByNombre("Mouse"));
		System.out.println("Busqueda por categoria");

		productoService.findByCategoria("Tecnologia").forEach(
				p -> System.out.println(p)
		);

		System.out.println("Busqueda por stock y precio");
		productoService.findByStockAndPrecio(150, 250.0).forEach(
				p-> System.out.println(p)
		);
		System.out.println("Listado de descendente por precio");
		productoService.findByOrderByPrecioAsc().forEach(
				p-> System.out.println(p)
		);
		System.out.println("--------------------Consultas JPQL----------------------------");
		System.out.println("Buscar por nombre con JPQL");
		System.out.println(productoService.buscarProductoPorNombre("Televisor"));

		System.out.println("Buscar por categoria con JPQL");
		productoService.buscarProductoPorCategoria("Tecnologia").forEach(
				p-> System.out.println(p)
		);

		System.out.println("Buscar por precio mayor Q con JPQL");
		productoService.buscarPorPrecioMayorQue(100.0).forEach(
				p-> System.out.println(p)
		);
	}

	/*@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/persistencia");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}*/

}