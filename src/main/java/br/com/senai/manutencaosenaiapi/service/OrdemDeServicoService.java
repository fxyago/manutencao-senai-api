package br.com.senai.manutencaosenaiapi.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import br.com.senai.manutencaosenaiapi.entity.OrdemDeServico;
import br.com.senai.manutencaosenaiapi.entity.Peca;
import br.com.senai.manutencaosenaiapi.repository.OrdensDeServicoRepository;

@Service
@Validated
public class OrdemDeServicoService {

	@Autowired
	private OrdensDeServicoRepository repository;
	
	public OrdemDeServico inserir(
			@Valid 
			@NotNull(message = "A nova ordem é obrigatoria")
			OrdemDeServico novaOrdem) {
		
		
		this.validar(novaOrdem);
		var ordemSalva = novaOrdem;
		return repository.save(ordemSalva);
	}


	public OrdemDeServico alterar(
			@Valid 
			@NotNull(message = "A ordem salva é obrigatória")
			OrdemDeServico ordemSalva) {
		
		this.validar(ordemSalva);
		var ordemAtualizada = ordemSalva;
		return repository.save(ordemAtualizada);
	}
	
	private void validar(OrdemDeServico novaOrdem) {
		Preconditions.checkArgument(novaOrdem.getDescricaoDoReparo() == null,
				"A descrição de reparo não deve ser informada na abertura");
		Preconditions.checkArgument(novaOrdem.getDataDeEncerramento() == null,
				"A data de encerramento não deve ser informada na abertura");
		Preconditions.checkArgument(novaOrdem.getPecasDeReparo().isEmpty(), 
				"Não devem ser informadas peças na abertura da ordem");
	}
	
	public OrdemDeServico fechar(
			@Valid 
			@NotNull(message = "A ordem é obrigatória")
			OrdemDeServico ordem) {
		Preconditions.checkArgument(ordem.getDataDeEncerramento() != null,
				"A data de encerramento é obrigatoria");
		Preconditions.checkArgument(!Strings.isNullOrEmpty(ordem.getDescricaoDoReparo()),
				"A descrição do problema é obrigatória");
		
		var isPosterior = ordem.getDataDeEncerramento().isAfter(ordem.getDataDeAbertura());
		Preconditions.checkArgument(isPosterior, "A data de encerramento deve ser posterior a data de abertura");
		
		for (Peca peca : ordem.getPecasDeReparo()) {
			int qtdeDeOcorrencias = 0;
			for (Peca outraPeca : ordem.getPecasDeReparo()) 
				if (peca.equals(outraPeca)) {
					qtdeDeOcorrencias++;
				}
			Preconditions.checkArgument(qtdeDeOcorrencias == 1, 
					"A peça: " + peca.getDescricao() + " ja foi adicionada");
		}
		
		var ordemAtualizada = ordem;
		return repository.save(ordemAtualizada);
	}
	
	public List<OrdemDeServico> listarPor(
			@NotNull(message = "O id do cliente é obrigatório")
			@Min(value = 1, message = "O id deve ser maior que zero")
			Integer idDoCliente) {
		
		return repository.findAll();
	}
	
	public OrdemDeServico buscarPor(
			@NotNull(message = "O id da ordem é obrigatoria")
			@Min(value = 1, message = "O id da ordem deve ser maior que zero") 
			Integer id) {
		return repository.buscarPor(id);
	}
	
	public void removerPor(
			@NotNull(message = "O id da ordem é obrigatorio")
			@Min(value = 1, message = "O id deve ser maior que zero")
			Integer idDaOrdem) {
		
	}
	
	
	
}
