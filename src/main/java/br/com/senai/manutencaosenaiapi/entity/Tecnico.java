package br.com.senai.manutencaosenaiapi.entity;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Tecnico {

	@EqualsAndHashCode.Include
	private Integer id;
	
	@NotEmpty(message = "O nome não pode ser nulo")
	@Size(max = 100, message = "O nome não pode conter mais de 100 caracteres")
	private String nomeCompleto;
	
	@NotNull(message = "A data de admissão não pode ser nula")
	@PastOrPresent(message = "A data de admissão não pode ser posterior a data atual")
	private LocalDate dataDeAdmissao;
	
	public boolean isNovo() {
		return getId() != null && getId() == 0;
	}
	
}
