package br.com.zupacademy.achiley.casadocodigo.shared;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.achiley.casadocodigo.localizacao.estado.Estado;
import br.com.zupacademy.achiley.casadocodigo.localizacao.estado.EstadoForm;
import br.com.zupacademy.achiley.casadocodigo.localizacao.estado.EstadoRepository;

@Component
public class UniqueStateValidator implements Validator {
	
	@Autowired
	private EstadoRepository repository;
	
	@Override
    public boolean supports(Class<?> klass) {
        return EstadoForm.class.isAssignableFrom(klass);
    }
	
	@Override
    public void validate(Object object, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
        EstadoForm form = (EstadoForm) object; 
        Optional <Estado> optional = repository.findByNomeAndPaisId(form.getNome(), form.getPaisId());
        if (optional.isPresent()){
            errors.rejectValue("nome", null, 
            				   "Este pais ja possui um estado cadastrado com o nome " 
            				   + form.getNome());
        }
    }
}
