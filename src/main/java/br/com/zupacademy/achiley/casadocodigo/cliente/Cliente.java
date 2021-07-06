package br.com.zupacademy.achiley.casadocodigo.cliente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.achiley.casadocodigo.localizacao.estado.Estado;
import br.com.zupacademy.achiley.casadocodigo.localizacao.pais.Pais;
import br.com.zupacademy.achiley.casadocodigo.shared.Document;

@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	@Document
	private String documento;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotNull
	@ManyToOne
	private Pais pais;
	@ManyToOne
	private Estado estado;
	
	@Deprecated
	public Cliente() {
		
	}
	
	public Cliente(@NotBlank String nome, @NotBlank String sobrenome, @NotBlank @Email String email,
			@NotBlank String documento, @NotBlank String telefone, @NotBlank String cep, @NotBlank String endereco,
			@NotBlank String complemento, @NotBlank String cidade, @NotNull Pais pais) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.documento = documento;
		this.telefone = telefone;
		this.cep = cep;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Cliente [\nNome Completo = " + nome + sobrenome +
				" \nEmail = " + email +
				" \nDocumento = " + documento +
				" \nTelefone = "+ telefone +
				" \nCEP = " + cep +
				" \nEndereco = " + endereco +
				" \nComplemento = " + complemento +
				" \nCidade = "+ cidade + 
				" \nPais = " + pais.getNome() +
				" \n]";
	}
}
