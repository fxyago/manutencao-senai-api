package br.com.senai.manutencaosenaiapi.entity;

import java.time.LocalDate;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Tecnico {

	@EqualsAndHashCode.Include
	private Integer id;
	private String nomeCompleto;
	private LocalDate dataDeAdmissao;
	
}
