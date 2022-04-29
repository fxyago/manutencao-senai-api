package br.com.senai.manutencaosenaiapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import br.com.senai.manutencaosenaiapi.entity.Peca;
import br.com.senai.manutencaosenaiapi.repository.PecasRepository;
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
	private PecasRepository pecasRepository;
	
	@Autowired
	private OrdemDeServicoService ordemService;
	
	@Bean	
	public CommandLineRunner commandLineRunner(ApplicationContext ac) {
		return args -> {
			try {
				
//				Peca novaPeca = new Peca();
//				novaPeca.setDescricao("Plaquinha topzera");
//				novaPeca.setEspecificacoes("DDR7 AM7 GT-R");
//				novaPeca.setQtdeEmEstoque(666);
//				Peca pecaSalva = pecasRepository.save(novaPeca);
//				
//				System.out.println("Id da peca: " + pecaSalva.getId());
				
				List<Peca> pecas = pecasRepository.findAll();
				pecas.forEach(System.out::println);
				
			} catch (Exception e) {
				
			}
		};
	}

}
