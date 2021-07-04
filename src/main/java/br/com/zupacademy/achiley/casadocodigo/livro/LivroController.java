package br.com.zupacademy.achiley.casadocodigo.livro;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<LivroDetailsDto> detalhar(@PathVariable Long id) {
		Optional<Livro> livro = livroRepository.findById(id);
		if (livro.isPresent()) {
			return ResponseEntity.ok(new LivroDetailsDto(livro.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
}
