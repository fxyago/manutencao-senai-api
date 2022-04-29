package br.com.senai.manutencaosenaiapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.senai.manutencaosenaiapi.entity.Tecnico;

@Repository
public interface TecnicosRepository extends JpaRepository<Tecnico, Integer> {

	@Modifying
	@Query(value = "DELETE FROM Tecnico t WHERE t.id = :id")
	void deletarPor(Integer id);
	
}
