package br.com.senai.manutencaosenaiapi;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import br.com.senai.manutencaosenaiapi.entity.OrdemDeServico;
import br.com.senai.manutencaosenaiapi.entity.Peca;
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
				
//				var clientes = clienteService.listarPor("mon");
//				var clienteSelecionado = clientes.get(0);
//				
//				var tecnicos = tecnicoService.listarPor("get");
//				var tecnicoSelecionado = tecnicos.get(0);
//				
//				var pecas = pecaService.listarPor("p");
//				var pecasDoReparo = new ArrayList<Peca>();
//				pecasDoReparo.add(pecas.get(0));
//				pecasDoReparo.add(pecas.get(1));
//				
//				var novaOrdem = new OrdemDeServico();
//				novaOrdem.setCliente(clienteSelecionado);
//				novaOrdem.setTecnico(tecnicoSelecionado);
//				novaOrdem.setDataDeAbertura(LocalDate.of(2022, 5, 6));
//				novaOrdem.setDescricaoDoProblema("Essa porcaria n funciona");
//				novaOrdem.setPecasDeReparo(pecasDoReparo);
//				
//				this.ordemService.inserir(novaOrdem);
				
//				var ordemSalva = ordemService.buscarPor(10);
//				System.out.println(ordemSalva);
				
				var ordemSalva = ordemService.buscarPor(10);
				ordemSalva.getPecasDeReparo().add(ordemSalva.getPecasDeReparo().get(0));
				ordemSalva.setDescricaoDoReparo("cliente fumante");
				ordemSalva.setDataDeEncerramento(LocalDate.of(2022, 5, 7));
				
				this.ordemService.fechar(ordemSalva);
				
				
//				Tecnico novoTecnico = new Tecnico();
//				novoTecnico.setNomeCompleto("Getúlio Vargas");
//				novoTecnico.setDataDeAdmissao(LocalDate.of(1951, 1, 31));
//				this.tecnicoService.inserir(novoTecnico);
				
//				Tecnico tecnicoSalvo = tecnicoService.buscarPor(18);
//				tecnicoSalvo.setNomeCompleto("Getúlio Vargas");
//				this.tecnicoService.alterar(tecnicoSalvo);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
	}

}
