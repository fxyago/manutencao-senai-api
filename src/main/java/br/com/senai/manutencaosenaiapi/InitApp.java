package br.com.senai.manutencaosenaiapi;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import br.com.senai.manutencaosenaiapi.entity.Tecnico;
import br.com.senai.manutencaosenaiapi.service.ClienteService;
import br.com.senai.manutencaosenaiapi.service.OrdemDeServicoService;
import br.com.senai.manutencaosenaiapi.service.PecaService;
import br.com.senai.manutencaosenaiapi.service.TecnicoService;

@SpringBootApplication
public class InitApp {

	public static void main(String[] args) {
		SpringApplication.run(InitApp.class, args);
	}
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private PecaService pecaService;
	
	@Autowired
	private OrdemDeServicoService ordemService;
	
	@Transactional
	@Bean	
	public CommandLineRunner commandLineRunner(ApplicationContext ac) {
		return args -> {
			try {
				
//				Tecnico novoTecnico = new Tecnico();
//				novoTecnico.setNomeCompleto("Getúlio Vargas");
//				novoTecnico.setDataDeAdmissao(LocalDate.of(1951, 1, 31));
//				this.tecnicoService.inserir(novoTecnico);
				
				Tecnico tecnicoSalvo = tecnicoService.buscarPor(18);
				tecnicoSalvo.setNomeCompleto("Getúlio Vargas");
				this.tecnicoService.alterar(tecnicoSalvo);
				
			} catch (Exception e) {
//				e.printStackTrace();
			}
		};
	}

}
