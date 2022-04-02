package br.com.senai.manutencaosenaiapi.entity;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Tecnico {

	private Integer id;
	private String nomeCompleto;
	private LocalDate dataDeAdmissao;
	
}
