package br.com.zupacademy.achiley.casadocodigo.shared;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.achiley.casadocodigo.cliente.ClienteForm;
import br.com.zupacademy.achiley.casadocodigo.localizacao.estado.Estado;

@Component
public class HasStateValidator implements Validator  {
	@Autowired
	private EntityManager manager;
	
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
        
        if(form.getEstadoId()== null) {
        	
	        Query query = manager.createQuery("select 1 from "+Estado.class.getName()+ " where pais_id=:value");
			query.setParameter("value", form.getPaisId());
			List<?> result = query.getResultList();
			
	        if (!result.isEmpty()){
	            errors.rejectValue("estadoId", null, 
	            				   "O pais indicado possui estados cadastrados, "
	            				   + "portanto, o campo estado nao pode estar vazio");
	        }
        }
    }
}
