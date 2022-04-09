package br.com.senai.manutencaosenaiapi.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Peca {

	@EqualsAndHashCode.Include
	private Integer id;
	
	@NotEmpty(message = "A descrição não pode")
	private String descricao;
	
	private String especificacoes;
	
	@NotNull(message = "A quantidade é obrigatoria")
	@Min(value = 0, message = "A quantidade não pode ser menor que zero")
	private Integer qtdeEmEstoque;
	
}
