package br.com.zupacademy.achiley.casadocodigo.shared;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.achiley.casadocodigo.cliente.ClienteForm;
import br.com.zupacademy.achiley.casadocodigo.localizacao.estado.Estado;
import br.com.zupacademy.achiley.casadocodigo.localizacao.estado.EstadoRepository;

@Component
public class StateBelongsValidator implements Validator{
	@Autowired
	private EstadoRepository repository;
	
	@Override
    public boolean supports(Class<?> klass) {
        return ClienteForm.class.isAssignableFrom(klass);
    }
	
	@Override
    public void validate(Object object, Errors errors) {
		
		if(errors.hasErrors()) {
			return;
		}
		
        ClienteForm form = (ClienteForm) object; 
        
        if(!(form.getEstadoId()== null)) {
        	
        	Optional <Estado> optional = repository.findByIdAndPaisId(form.getEstadoId(), form.getPaisId());
			
	        if (!optional.isPresent()){
	            errors.rejectValue("estadoId", null, 
	            				   "O id "+ form.getEstadoId() + 
	            				   " nao corresponde a nenhum estado cadastrado no pais indicado");
	        }
        }
    }
}
