package br.com.senai.manutencaosenaiapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;

@Data
@Entity
@Table(name = "tipos_pecas")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TipoDePeca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Include
	private Integer id;
	
	@NotEmpty(message = "A descrição não pode ser vazia")
	@Column(name = "descricao")
	@Size(max = 150, message = "A descrição não pode conter mais de {max} caracteres")
	private String descricao;
	
}
