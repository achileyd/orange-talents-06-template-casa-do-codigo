package br.com.zupacademy.achiley.casadocodigo.livro;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private EntityManager manager;
	
	@Autowired
	private LivroRepository livroRepository;

	@PostMapping
	@Transactional
	public String cadastrar(@RequestBody @Valid LivroForm form) {
		Livro livro = form.converter(manager);
		manager.persist(livro);
		
		return livro.toString();
		
	}
	
	@GetMapping
	public List<LivroDto> listar()  {
		List<Livro> livros = livroRepository.findAll();
		return LivroDto.converter(livros);
	}
}
