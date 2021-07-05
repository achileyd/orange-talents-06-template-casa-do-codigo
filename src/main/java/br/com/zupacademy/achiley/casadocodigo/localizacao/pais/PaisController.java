package br.com.zupacademy.achiley.casadocodigo.localizacao.pais;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PaisController {
	
	@Autowired
	private EntityManager manager;

    
	@PostMapping("/paises")
	@Transactional
	public String cadastrarPais(@RequestBody @Valid PaisForm form) {
		Pais pais = new Pais(form.getNome());
		manager.persist(pais);
		
		return pais.toString();
		
	}
}
