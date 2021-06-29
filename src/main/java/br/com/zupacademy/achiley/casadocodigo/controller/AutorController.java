package br.com.zupacademy.achiley.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.achiley.casadocodigo.form.AutorForm;
import br.com.zupacademy.achiley.casadocodigo.model.Autor;
import br.com.zupacademy.achiley.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepository;

	@PostMapping
	public String cadastrar(@RequestBody @Valid AutorForm form) {
		Autor autor = form.converter();
		autorRepository.save(autor);
		
		return autor.toString();
		
	}

} 
