package br.com.senai.manutencaosenaiapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.senai.manutencaosenaiapi.entity.TipoDePeca;

@Repository
public interface TiposDePecasRepository extends JpaRepository<TipoDePeca, Integer>{

	@Query(value = "SELECT t FROM TipoDePeca t WHERE Upper(t.descricao) LIKE Upper(:desc)")
	List<TipoDePeca> listarPor(@Param("desc") String descricao);
	
}
