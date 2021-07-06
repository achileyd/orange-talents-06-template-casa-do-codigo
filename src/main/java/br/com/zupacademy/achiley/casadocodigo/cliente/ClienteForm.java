package br.com.zupacademy.achiley.casadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.achiley.casadocodigo.localizacao.estado.Estado;
import br.com.zupacademy.achiley.casadocodigo.localizacao.pais.Pais;
import br.com.zupacademy.achiley.casadocodigo.shared.Document;
import br.com.zupacademy.achiley.casadocodigo.shared.ExistsId;
import br.com.zupacademy.achiley.casadocodigo.shared.UniqueValue;

public class ClienteForm {

	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	@Email
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;
	@NotBlank
	@Document
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento")
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
	@ExistsId(domainClass = Pais.class)
	private Integer paisId;
	private Long estadoId;
	
	@Deprecated
	public ClienteForm() {
		
	}
	
	public ClienteForm(@NotBlank String nome, @NotBlank String sobrenome, @NotBlank @Email String email,
			@NotBlank String documento, @NotBlank String telefone, @NotBlank String cep, @NotBlank String endereco,
			@NotBlank String complemento, @NotBlank String cidade, @NotNull Integer paisId) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.documento = documento;
		this.telefone = telefone;
		this.cep = cep;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.paisId = paisId;
	}

	public Cliente converter(EntityManager manager) {
		Pais pais = manager.find(Pais.class, paisId);
		
		Cliente cliente = new Cliente (nome, sobrenome, email, documento, telefone, cep, endereco, complemento, cidade, pais);
		
		if(!(estadoId == null)) {
			Estado estado = manager.find(Estado.class, estadoId);
			cliente.setEstado(estado);
		}
		return cliente;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public String getDocumento() {
		return documento;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Integer getPaisId() {
		return paisId;
	}

	public Long getEstadoId() {
		return estadoId;
	}
		
}
