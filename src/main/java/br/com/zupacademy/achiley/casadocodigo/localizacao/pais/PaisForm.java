package br.com.zupacademy.achiley.casadocodigo.localizacao.pais;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.achiley.casadocodigo.shared.UniqueValue;

public class PaisForm {
	
	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;
	
	@Deprecated
	public PaisForm() {
		
	}
	
	public PaisForm(@NotBlank String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
}
