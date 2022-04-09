package br.com.senai.manutencaosenaiapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import br.com.senai.manutencaosenaiapi.service.ClienteService;
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
	
	@Bean	
	public CommandLineRunner commandLineRunner(ApplicationContext ac) {
		return args -> {
			try {
				/*Tecnico novoTecnico = new Tecnico();
				novoTecnico.setNomeCompleto("Josevildo Soares");
				LocalDate dataDeAdmissao = LocalDate.of(2022, 4, 7);
				novoTecnico.setDataDeAdmissao(dataDeAdmissao);
				this.service.inserir(novoTecnico);
				Tecnico tecnicoSalvo = new Tecnico();
				tecnicoSalvo.setId(1);
				tecnicoSalvo.setNomeCompleto("Joanecleidson");
				tecnicoSalvo.setDataDeAdmissao(LocalDate.now());
				this.service.alterar(tecnicoSalvo);
				System.out.println("Técnico salvo com sucesso");*/
//				this.tecnicoService.listarPor("Josévaldo");
//				this.tecnicoService.removerPor(1);
				
				/*Cliente novoCliente = new Cliente();
				novoCliente.setNome("Joao");
				novoCliente.setSobrenome("da Silva");
				novoCliente.setCpf("12312312312");
				novoCliente.setSexo(Sexo.MASCULINO);
				novoCliente.setEndereco("Rua das couves");
				novoCliente.setDataDeNascimento(LocalDate.of(1993, 3, 15));
				this.clienteService.inserir(novoCliente);*/
				
//				Peca novaPeca = new Peca();
//				novaPeca.setDescricao("Teclado");
//				novaPeca.setQtdeEmEstoque(10);
//				System.out.println(novaPeca);
				
//				this.pecaService.inserir(null);
				this.pecaService.alterar(null);
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		};
	}

}
