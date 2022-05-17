package br.com.senai.manutencaosenaiapi.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.manutencaosenaiapi.entity.TipoDePeca;
import br.com.senai.manutencaosenaiapi.repository.TiposDePecasRepository;

@Service
public class TipoDePecaService {

	@Autowired
	private TiposDePecasRepository repository;
	
	public TipoDePeca inserir(
			@Valid 
			@NotNull(message = "O tipo não pode ser nulo")
			TipoDePeca tipoRecebido) {
		return repository.save(tipoRecebido);
	}
	
	public TipoDePeca editar(
			@Valid 
			@NotNull(message = "O tipo não pode ser nulo") 
			TipoDePeca tipoSalvo) {
		return repository.save(tipoSalvo);
	}
	
	public List<TipoDePeca> listarPor(
			@NotEmpty(message = "A descrição para busca é obrigatória")
			@NotBlank(message = "A descrição não pode estar vazia")
			String descricao) {
		return repository.listarPor(String.format("%%%s%%", descricao));
	}
	
	public void removerPor(
			@NotNull(message = "O id do tipo não pode ser nulo")
			@Min(value = 1, message = "O id deve ser maior que 1")
			Integer id) {
		repository.deleteById(id);
	}
	
	public TipoDePeca buscarPor(
			@NotNull(message = "O id do tipo não pode ser nulo")
			@Min(value = 1, message = "O id deve ser maior que 1")
			Integer id) {
		return repository.findById(id).orElseThrow();
	}
	
}
