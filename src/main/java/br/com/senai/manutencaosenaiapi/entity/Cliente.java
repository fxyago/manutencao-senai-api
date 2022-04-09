package br.com.senai.manutencaosenaiapi.entity;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import br.com.senai.manutencaosenaiapi.enums.Sexo;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente {

	@Setter(value = AccessLevel.NONE)
	@EqualsAndHashCode.Include
	private Integer id;
	
	@NotEmpty(message = "O nome não pode ser nulo")
	private String nome;
	
	@NotEmpty(message = "O sobrenome não pode ser nulo")
	private String sobrenome;
	
	@Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)", message = "O cpf é inválido")
	@NotEmpty(message = "O cpf não pode ser nulo")
	private String cpf;
	
	@NotEmpty(message = "O sexo é obrigatória")
	private Sexo sexo;
	
	@NotEmpty(message = "O endereço não pode ser nulo")
	private String endereco;
	
	@NotNull(message = "A data de nascimento é obrigatória")
	@Past(message = "A data de nascimento deve ser anterior a data atual")
	private LocalDate dataDeNascimento;
	
	public Integer getIdade() {
		int idade = LocalDate.now().getYear() - getDataDeNascimento().getYear();
		return idade;
	}
	
}
