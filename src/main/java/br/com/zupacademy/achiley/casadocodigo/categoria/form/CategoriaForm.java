package br.com.zupacademy.achiley.casadocodigo.categoria.form;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.achiley.casadocodigo.categoria.validation.UniqueName;

public class CategoriaForm {
	
	@NotBlank
	@UniqueName
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
