package br.com.zupacademy.achiley.casadocodigo.autor.validation;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zupacademy.achiley.casadocodigo.autor.Autor;
import br.com.zupacademy.achiley.casadocodigo.autor.repository.AutorRepository;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
	 
	private String value;

	    @Autowired
	    AutorRepository autorRepository;

	    @Override
	    public void initialize(UniqueEmail constraintAnnotation) {
	        this.value = constraintAnnotation.value();
	    }

	    @Override
	    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
	        Optional<Autor> emailNovoAutor = autorRepository.findByEmail(email);
	        if (emailNovoAutor.isPresent()){
	            return false;
	        }
	        return true;
	    }
}
