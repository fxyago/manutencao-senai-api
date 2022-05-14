package br.com.senai.manutencaosenaiapi;

import java.awt.EventQueue;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import br.com.senai.manutencaosenaiapi.view.TelaConsultaDePeca;

@SpringBootApplication
public class InitApp {

	@Autowired
	private TelaConsultaDePeca telaDeConsulta;

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(InitApp.class);
		builder.headless(false);
		builder.run(args);
	}

	@Transactional
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ac) {
		return args -> {
			try {

				EventQueue.invokeLater(() -> {
					try {
						telaDeConsulta.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				});

			} catch (Exception e) {
				e.printStackTrace();
			}
		};
	}

}
