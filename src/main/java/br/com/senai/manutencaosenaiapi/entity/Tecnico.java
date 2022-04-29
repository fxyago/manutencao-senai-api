package br.com.senai.manutencaosenaiapi.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "Tecnico")
@Table(name = "tecnicos", schema = "")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Tecnico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;
	
	@Column(name = "nm_completo")
	@NotEmpty(message = "O nome não pode ser nulo")
	@Size(max = 100, message = "O nome não pode conter mais de 100 caracteres")
	private String nomeCompleto;
	
	@Column(name = "dt_admissao")
	@NotNull(message = "A data de admissão não pode ser nula")
	@PastOrPresent(message = "A data de admissão não pode ser posterior a data atual")
	private LocalDate dataDeAdmissao;
	
	@Transient
	public boolean isNovo() {
		return getId() == null || getId() == 0;
	}

}
