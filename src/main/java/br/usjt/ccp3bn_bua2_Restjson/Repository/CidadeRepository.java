package br.usjt.ccp3bn_bua2_Restjson.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import br.usjt.ccp3bn_bua2_Restjson.Model.Cidade;


public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	public List<Cidade> findByNameStartingWith(String nome);
	public List<Cidade> findByLatitudeAndLongitude(String la, String lo);
	
}
