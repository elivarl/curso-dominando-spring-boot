package com.icodeap.springbootapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppApplication.class, args);

		/*
		// inicializar contexto
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		BancaWeb bwContenedorSpring = context.getBean(BancaWeb.class);


		//BancaWeb bw = new BancaWeb(new Pago());
		bwContenedorSpring.realizarTransferencia();

		context.close();
		*/

	}

	@GetMapping
	public String saludar(){
		return "Hola desde Spring Boot";
	}

}




class BancaWeb{
	//private TransferenciaBancaria tb;
	private Transferencia t;

	public BancaWeb(Transferencia t){
		this.t = t;
	}
	public void realizarTransferencia(){
		t.transferir();
	}

}

interface Transferencia {
	void transferir();
}

class TransferenciaBancaria implements Transferencia{

	@Override
	public void transferir() {
		System.out.println("Transferir dinero...");
	}
}

class Pago implements Transferencia{

	@Override
	public void transferir() {
		System.out.println("Pago realizado");
	}
}


/*class TransferenciaBancaria{
	public void transferir(){
		System.out.println("Transfiriendo dinero.....");
	}
}*/

// crear una clase de configuracion
@Configuration
class AppConfig{

	@Bean
	public Transferencia transferencia(){
		return new TransferenciaBancaria();
	}

	@Bean
	public BancaWeb bancaWeb(){
		return new BancaWeb(transferencia());
	}


}






