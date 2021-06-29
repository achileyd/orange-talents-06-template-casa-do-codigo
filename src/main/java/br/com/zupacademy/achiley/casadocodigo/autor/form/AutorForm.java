package br.com.zupacademy.achiley.casadocodigo.autor.form;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.achiley.casadocodigo.autor.Autor;
import br.com.zupacademy.achiley.casadocodigo.autor.validation.UniqueEmail;

public class AutorForm {
	
	@NotBlank
	private String nome;
	@NotBlank
	@Email
	@UniqueEmail
	private String email;
	@NotBlank
	@Size(max = 400)
	private String descricao;
	@NotNull
	private LocalDateTime dataRegistro = LocalDateTime.now();
	
	

	public AutorForm(@NotBlank String nome, @NotBlank @Email String email,
			@NotBlank @Size(max = 400) String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}


	public String getEmail() {
		return email;
	}

	public Autor converter() {
		return new Autor(this.nome, this.email, this.descricao);
	}
	
}