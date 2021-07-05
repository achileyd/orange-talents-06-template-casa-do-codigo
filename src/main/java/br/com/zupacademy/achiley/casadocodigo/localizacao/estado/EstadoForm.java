package br.com.zupacademy.achiley.casadocodigo.localizacao.estado;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.achiley.casadocodigo.localizacao.pais.Pais;
import br.com.zupacademy.achiley.casadocodigo.shared.ExistsId;

public class EstadoForm {
	
	@NotBlank
	private String nome;
	@NotNull
	@ExistsId(domainClass = Pais.class)
	private Integer paisId;
	
	public EstadoForm(@NotBlank String nome, @NotNull Integer paisId) {
		this.nome = nome;
		this.paisId = paisId;
	}

	public String getNome() {
		return nome;
	}

	public Integer getPaisId() {
		return paisId;
	}

	public Estado converter(EntityManager manager) {
		Pais pais = manager.find(Pais.class, paisId);
		return new Estado(nome, pais);
	}

}
