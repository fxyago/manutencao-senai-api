package br.com.senai.manutencaosenaiapi.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;

import br.com.senai.manutencaosenaiapi.entity.Cliente;

@Service
public class ClienteService {
	
	private final int IDADE_MINIMA = 12;
	
	public Cliente inserir(@Valid Cliente novoCliente) {
		
		Cliente clienteSalvo = new Cliente();
		Preconditions.checkArgument(novoCliente.getIdade() > IDADE_MINIMA, "O cliente deve possuir mais de 12 anos");
		
		return clienteSalvo;
	}
	
	
	
}
