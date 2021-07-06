package br.com.zupacademy.achiley.casadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.achiley.casadocodigo.shared.HasStateValidator;
import br.com.zupacademy.achiley.casadocodigo.shared.StateBelongsValidator;


@RestController
public class ClienteController {
	
	@Autowired
	private EntityManager manager;
	
	@Autowired
	private HasStateValidator validator;
	
	@Autowired
	private StateBelongsValidator validator2;
	
    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(validator, validator2);
    }
	@PostMapping("/cadastro-cliente")
	@Transactional
	public String cadastrar(@RequestBody @Valid ClienteForm form) {
		Cliente cliente = form.converter(manager);
		manager.persist(cliente);
		
		return cliente.toString();
	}
}
