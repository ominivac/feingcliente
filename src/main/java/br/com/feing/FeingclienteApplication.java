package br.com.feing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@EnableFeignClients //habilita o Feign na aplicação  :https://medium.com/@felixgilioli/feign-uma-maneira-elegante-de-criar-clientes-http-em-java-c7c13c318cbe 

@SpringBootApplication
public class FeingclienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeingclienteApplication.class, args);
	}

}
