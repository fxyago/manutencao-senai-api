package br.com.senai.manutencaosenaiapi.service;

import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;

import br.com.senai.manutencaosenaiapi.entity.Tecnico;

@Service
public class TecnicoService {

	public Tecnico inserir(Tecnico novoTecnico) {
		
		Preconditions.checkNotNull(novoTecnico, "O técnico não pode ser nulo");
		
		Tecnico tecnicoSalvo = novoTecnico;
		return tecnicoSalvo;
	}
	
}
