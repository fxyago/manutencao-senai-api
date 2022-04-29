package br.com.senai.manutencaosenaiapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.manutencaosenaiapi.entity.Tecnico;

@Repository
public interface TecnicosRepository extends JpaRepository<Tecnico, Integer> {

}
