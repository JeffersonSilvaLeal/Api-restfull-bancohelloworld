package br.com.bancohelloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// Configurações básicas para ter um projeto completo em spring boot
@SpringBootApplication // Esta anotação faz o Start da aplicação,Configura o projeto,e adiciona as congigurações adicionais
@EntityScan(basePackages = {"br.com.bancohelloworld.model"}) // Lê todas as classes dentro do model com anotacão @Entity e cria as tabelas automaticas
@ComponentScan(basePackages = {"br.*"}) // Varre nossos packages e configura automatico a injeção de depedência
@EnableJpaRepositories(basePackages = {"br.com.bancohelloworld.repository"}) // Indica qual a pasta que irá ficar nossas Interfaces de  Persistências
@EnableTransactionManagement // Gerencia de transação Controla as transações no banco de dados
@EnableWebMvc // Ativa recurso de MVC (opicional)
@RestController // Ativa a parte de Rest para criar Api rest com serviços RestFull
@EnableAutoConfiguration // Faz a configuração automatica
public class BancohelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancohelloworldApplication.class, args);
	}

}
