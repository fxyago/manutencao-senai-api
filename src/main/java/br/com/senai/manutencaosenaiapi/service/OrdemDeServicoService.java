package br.com.senai.manutencaosenaiapi.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import br.com.senai.manutencaosenaiapi.entity.OrdemDeServico;

@Service
@Validated
public class OrdemDeServicoService {

	public OrdemDeServico inserir(
			@Valid 
			@NotNull(message = "A nova ordem é obrigatoria")
			OrdemDeServico novaOrdem) {
		
		validar(novaOrdem);
		
		OrdemDeServico ordemSalva = novaOrdem;
		return ordemSalva;
	}


	public OrdemDeServico alterar(
			@Valid 
			@NotNull(message = "A ordem salva é obrigatória")
			OrdemDeServico ordemSalva) {
		
		this.validar(ordemSalva);
		OrdemDeServico ordemAtualizada = ordemSalva;
		return ordemAtualizada;
	}
	
	private void validar(OrdemDeServico novaOrdem) {
		Preconditions.checkArgument(novaOrdem.getDescricaoDoReparo() == null,
				"A descrição de reparo não deve ser informada na abertura");
		Preconditions.checkArgument(novaOrdem.getDataDeEncerramento() == null,
				"A data de encerramento não deve ser informada na abertura");
	}
	
	public OrdemDeServico fechar(
			@Valid 
			@NotNull(message = "A ordem é obrigatória")
			OrdemDeServico ordem) {
		Preconditions.checkArgument(ordem.getDataDeEncerramento() != null,
				"A data de encerramento é obrigatoria");
		Preconditions.checkArgument(!Strings.isNullOrEmpty(ordem.getDescricaoDoReparo()),
				"A descrição do problema é obrigatória");
		
		boolean isPosterior = ordem.getDataDeEncerramento().isAfter(ordem.getDataDeAbertura());
		Preconditions.checkArgument(isPosterior, "A data de encerramento deve ser posterior a data de abertura");
		
		OrdemDeServico ordemAtualizada = ordem;
		return ordemAtualizada;
	}
	
	public List<OrdemDeServico> listarPor(
			@NotNull(message = "O id do cliente é obrigatório")
			@Min(value = 1, message = "O id deve ser maior que zero")
			Integer idDoCliente) {
		
		
		
		return new ArrayList<OrdemDeServico>();
	}
	
	public void removerPor(
			@NotNull(message = "O id da ordem é obrigatorio")
			@Min(value = 1, message = "O id deve ser maior que zero")
			Integer idDaOrdem) {
		
	}
	
	
	
}
