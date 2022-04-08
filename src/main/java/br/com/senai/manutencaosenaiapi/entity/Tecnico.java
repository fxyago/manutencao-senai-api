package br.com.senai.manutencaosenaiapi.entity;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Tecnico {
	
	@Getter @Setter
	@EqualsAndHashCode.Include
	private Integer id;
	
	@NotEmpty(message = "O nome não pode ser nulo")
	@Size(max = 100, message = "O nome não pode conter mais de 100 caracteres")
	@Getter @Setter
	private String nomeCompleto;
	
	@NotNull(message = "A data de admissão não pode ser nula")
	@PastOrPresent(message = "A data de admissão não pode ser posterior a data atual")
	@Getter @Setter
	private LocalDate dataDeAdmissao;
	
	public boolean isNovo() {
		return getId() == null || getId() == 0;
	}

}
