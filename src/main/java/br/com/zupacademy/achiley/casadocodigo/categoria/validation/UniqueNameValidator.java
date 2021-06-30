package br.com.zupacademy.achiley.casadocodigo.categoria.validation;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zupacademy.achiley.casadocodigo.categoria.Categoria;
import br.com.zupacademy.achiley.casadocodigo.categoria.repository.CategoriaRepository;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

	private String value;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public void initialize(UniqueName constraintAnnotation) {
        this.value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String nome, ConstraintValidatorContext constraintValidatorContext) {
        Optional<Categoria> nomeNovaCategoria = categoriaRepository.findByNome(nome);
        if (nomeNovaCategoria.isPresent()){
            return false;
        }
        return true;
    }
}
