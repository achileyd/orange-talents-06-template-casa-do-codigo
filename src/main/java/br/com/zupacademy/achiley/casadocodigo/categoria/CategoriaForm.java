package br.com.zupacademy.achiley.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.achiley.casadocodigo.shared.UniqueValue;

public class CategoriaForm {
	
	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;
	
	@Deprecated
	public CategoriaForm() {
		
	}
	
	public CategoriaForm(@NotBlank String nome) {
		super();
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

}