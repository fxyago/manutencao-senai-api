package br.com.senai.manutencaosenaiapi.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.google.common.base.Preconditions;

import br.com.senai.manutencaosenaiapi.entity.Tecnico;
import br.com.senai.manutencaosenaiapi.repository.TecnicosRepository;

@Service
@Validated
public class TecnicoService {

	@Autowired
	private TecnicosRepository repository;
	
	public Tecnico inserir(
			@Valid
			@NotNull(message = "O técnico não pode ser nulo")
			Tecnico novoTecnico) {			
		Preconditions.checkArgument(novoTecnico.isNovo(),
				"O técnico já foi salvo");
		Tecnico tecnicoSalvo = this.repository.save(novoTecnico);	
		return tecnicoSalvo;				
	}
	
	public Tecnico alterar(
			@Valid
			@NotNull(message = "O técnico não pode ser nulo")
			Tecnico tecnicoSalvo) {
		Preconditions.checkArgument(!tecnicoSalvo.isNovo(), 
				"O técnico ainda não foi inserido");
		Tecnico tecnicoAtualizado = this.repository.save(tecnicoSalvo);
		return tecnicoAtualizado;
	}
	
	public List<Tecnico> listarPor(
			@NotEmpty(message = "O nome para busca não pode ser nulo")
			@NotBlank(message = "Não pode haver espaços antes do nome")
			String nome) {
		return this.repository.listarPor(String.format("%%%s%%", nome));
	}
	
	@Transactional
	public void removerPor(
			@NotNull(message = "O id de exclusão não pode ser nulo")
			@Min(value = 1, message = "O id deve ser maior que zero")
			Integer id) {
		this.repository.deleteById(id);
	}
	
	public Tecnico buscarPor(
			@NotNull(message = "O id de busca não pode ser nulo")
			@Min(value = 1, message = "O id deve ser maior que zero")
			Integer id) {
		return this.repository.findById(id).get();
	}
	
	
}
