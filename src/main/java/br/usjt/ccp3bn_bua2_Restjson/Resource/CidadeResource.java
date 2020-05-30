package br.usjt.ccp3bn_bua2_Restjson.Resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.ccp3bn_bua2_Restjson.Model.Cidade;
import br.usjt.ccp3bn_bua2_Restjson.Repository.CidadeRepository;

@RestController
@RequestMapping("/cidades")

public class CidadeResource {
	
	@Autowired
	private CidadeRepository cidadeRepository;

	@GetMapping()
	public List<Cidade> getAll(@RequestParam("nome") Optional<String> nome,
			
	@RequestParam("la") Optional<String> la,
			
	@RequestParam("la") Optional<String> lo){
		if (nome.isPresent()) {
			return cidadeRepository.findByNameStartingWith(nome.get());
		}
		if(la.isPresent() && lo.isPresent()) {
			
			return cidadeRepository.findByLatitudeAndLongitude(la.get(), lo.get());
		}
		    return cidadeRepository.findAll();
	}

	@PostMapping()
	
	@ResponseStatus(HttpStatus.CREATED)
	
	public void store(@RequestBody Cidade cidade) {
		
		cidadeRepository.save(cidade);
		
	}
}
