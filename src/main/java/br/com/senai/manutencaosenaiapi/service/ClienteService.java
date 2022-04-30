package br.com.senai.manutencaosenaiapi.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;

import br.com.senai.manutencaosenaiapi.entity.Cliente;
import br.com.senai.manutencaosenaiapi.repository.ClientesRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClientesRepository repository;
	
	private final int IDADE_MINIMA = 12;
	
	public Cliente inserir(
			@Valid 
			@NotNull(message = "O cliente não pode ser nulo")
			Cliente novoCliente) {
		this.validarIdadeDo(novoCliente);
		return this.repository.save(novoCliente);
	}

	public Cliente alterar(
			@Valid 
			@NotNull(message = "O cliente não pode ser nulo")
			Cliente clienteSalvo) {
		this.validarIdadeDo(clienteSalvo);
		return this.repository.save(clienteSalvo);
	}
	
	public List<Cliente> listarPor(
			@NotEmpty(message = "O nome para busca é obrigatório")
			@NotBlank(message = "O nome para busca não deve conter espaços")
			String nome) {
		return this.repository.listarPor(String.format("%%%s%%", nome));
	}
	
	public void removerPor(
			@NotNull(message = "O id para remoção não pode ser nulo")
			@Min(value = 1, message = "O id deve ser maior que zero")
			Integer id) {
		this.repository.deleteById(id);
	}
	
	private void validarIdadeDo(Cliente novoCliente) {
		Preconditions.checkArgument(novoCliente.getIdade() > IDADE_MINIMA, "O cliente deve possuir mais de 12 anos");
	}
	
	
	
}
