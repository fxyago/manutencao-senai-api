package br.com.senai.manutencaosenaiapi.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import br.com.senai.manutencaosenaiapi.enums.Sexo;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Entity(name = "Cliente")
@Table(name = "clientes")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.NONE)
	@EqualsAndHashCode.Include
	private Integer id;
	
	@Column(name = "nome")
	@NotEmpty(message = "O nome não pode ser nulo")
	private String nome;
	
	@Column(name = "sobrenome")
	@NotEmpty(message = "O sobrenome não pode ser nulo")
	private String sobrenome;
	
	@Column(name = "cpf")
	@Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)", message = "O cpf é inválido")
	@NotEmpty(message = "O cpf não pode ser nulo")
	private String cpf;
	
	@Column(name = "sexo")
	@Enumerated(EnumType.STRING)
	@NotEmpty(message = "O sexo é obrigatória")
	private Sexo sexo;
	
	@Column(name = "endereco")
	@NotEmpty(message = "O endereço não pode ser nulo")
	private String endereco;
	
	@Column(name = "dt_nascto")
	@NotNull(message = "A data de nascimento é obrigatória")
	@Past(message = "A data de nascimento deve ser anterior a data atual")
	private LocalDate dataDeNascimento;
	
	@Transient
	public Integer getIdade() {
		int idade = LocalDate.now().getYear() - getDataDeNascimento().getYear();
		return idade;
	}
	
}
