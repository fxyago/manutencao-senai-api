package br.com.senai.manutencaosenaiapi.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.senai.manutencaosenaiapi.entity.Tecnico;

@Service
@Validated
public class TecnicoService {

	public Tecnico inserir(@Valid
						   @NotNull(message = "O técnico não pode ser nulo")
						   Tecnico novoTecnico) {
		return novoTecnico;
	}
	
}
