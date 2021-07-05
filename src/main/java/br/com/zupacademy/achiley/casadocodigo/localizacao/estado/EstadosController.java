package br.com.zupacademy.achiley.casadocodigo.localizacao.estado;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.achiley.casadocodigo.shared.UniqueStateValidator;

@RestController
public class EstadosController {
	
	@Autowired
	private EntityManager manager;
	
	@Autowired
	private UniqueStateValidator validator;
	
    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(validator);
    }
	
	@PostMapping("/estados")
	@Transactional
	public String cadastrarEstado(@RequestBody @Valid EstadoForm form) {
		Estado estado = form.converter(manager);
		manager.persist(estado);
		
		return estado.toString();
		
	}

}
