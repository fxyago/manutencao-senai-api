package br.com.senai.manutencaosenaiapi.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;

import br.com.senai.manutencaosenaiapi.entity.Tecnico;

@Service
public class TecnicoService {

	public Tecnico inserir(Tecnico novoTecnico) {
		
		Preconditions.checkNotNull(novoTecnico, "O técnico não pode ser nulo");
		Preconditions.checkArgument(
				novoTecnico.getNomeCompleto() != null && !novoTecnico.getNomeCompleto().isEmpty(),
				"O nome é obrigatório");
		Preconditions.checkArgument(novoTecnico.getDataDeAdmissao() != null, 
				"A data de admissão é obrigatória");
		
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataDeAdmissao = novoTecnico.getDataDeAdmissao();
		
		Preconditions.checkArgument(dataDeAdmissao.isBefore(dataAtual)
				|| dataDeAdmissao.isEqual(dataAtual),
				"A data de admissão deve ser igual ou anterior a data atual");
		
		Tecnico tecnicoSalvo = novoTecnico;
		return tecnicoSalvo;
	}
	
}
