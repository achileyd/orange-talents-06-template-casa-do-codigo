package br.com.zupacademy.achiley.casadocodigo.categoria;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostMapping
	public String cadastrar(@RequestBody @Valid CategoriaForm form) {
		Categoria categoria = new Categoria(form.getNome());
		categoriaRepository.save(categoria);
		
		return categoria.toString();
	}
}