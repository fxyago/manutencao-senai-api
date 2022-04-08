package br.com.senai.manutencaosenaiapi;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import br.com.senai.manutencaosenaiapi.entity.Tecnico;
import br.com.senai.manutencaosenaiapi.service.TecnicoService;

@SpringBootApplication
public class InitApp {

	public static void main(String[] args) {
		SpringApplication.run(InitApp.class, args);
	}

	@Autowired
	private TecnicoService service;
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			
			try {
				Tecnico novoTecnico = new Tecnico();
				novoTecnico.setNomeCompleto("Josevildo Soares");
				
				LocalDate dataDeAdmissao = LocalDate.of(2022, 5, 17);
				novoTecnico.setDataDeAdmissao(dataDeAdmissao);
				
				this.service.inserir(novoTecnico);
				System.out.println("Técnico salvo com sucesso");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		};
	}
	
}
