package br.com.zupacademy.achiley.casadocodigo.localizacao.estado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.achiley.casadocodigo.localizacao.pais.Pais;

@Entity
@Table(name = "estados")
public class Estado {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@NotNull
	@ManyToOne
	private Pais pais;
	
	@Deprecated
	public Estado() {
		
	}
	
	public Estado(@NotBlank String nome, Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}
	
	@Override
	public String toString() {
		return "Estado: " + nome +
			   "\nPais: " +pais.getNome();
	}
	
}
