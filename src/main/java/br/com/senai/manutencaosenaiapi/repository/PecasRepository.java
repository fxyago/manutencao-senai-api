package br.com.senai.manutencaosenaiapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.manutencaosenaiapi.entity.Peca;

@Repository
public interface PecasRepository extends JpaRepository<Peca, Integer>{
	
	
	
}
