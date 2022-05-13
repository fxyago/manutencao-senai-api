package br.com.senai.manutencaosenaiapi;

import java.awt.EventQueue;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import br.com.senai.manutencaosenaiapi.service.ClienteService;
import br.com.senai.manutencaosenaiapi.service.OrdemDeServicoService;
import br.com.senai.manutencaosenaiapi.service.PecaService;
import br.com.senai.manutencaosenaiapi.service.TecnicoService;
import br.com.senai.manutencaosenaiapi.view.TelaCadastroDeTipo;

@SpringBootApplication
public class InitApp {

	@Autowired
	private TelaCadastroDeTipo telaDeCadastroDeTipo;
	
	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(InitApp.class);
		builder.headless(false);
		builder.run(args);
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
				
;;;;;;;;;;;;;;;;EventQueue.invokeLater(() -> {
;;;;;;;;;;;;;;;;;;;;try {
;;;;;;;;;;;;;;;;;;;;;;;;telaDeCadastroDeTipo.setVisible(true);
;;;;;;;;;;;;;;;;;;;;} catch (Exception e) {
;;;;;;;;;;;;;;;;;;;;;;;;e.printStackTrace();
;;;;;;;;;;;;;;;;;;;;}
				});
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
	}

}
