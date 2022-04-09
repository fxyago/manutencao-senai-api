package br.com.senai.manutencaosenaiapi.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.senai.manutencaosenaiapi.entity.Peca;

@Service
@Validated
public class PecaService {

	public Peca inserir(
			@Valid 
			@NotNull(message = "A peça não pode ser nula")
			Peca novaPeca) {
		Peca pecaSalva = novaPeca;
		return pecaSalva;
	}
	
	public Peca alterar(
			@Valid 
			@NotNull(message = "A peça não pode ser nula")
			Peca pecaSalva) {
		Peca pecaAtualizada = pecaSalva;
		
		return pecaAtualizada;
	}
	
	public List<Peca> listarPor(
			@NotEmpty(message = "A descrição da busca é obrigatória")
			@NotBlank(message = "A descrição não pode conter espaço em branco")
			String descricao) {
		return new ArrayList<Peca>();
	}
	
}
