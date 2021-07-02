package br.com.zupacademy.achiley.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zupacademy.achiley.casadocodigo.autor.Autor;
import br.com.zupacademy.achiley.casadocodigo.categoria.Categoria;
import br.com.zupacademy.achiley.casadocodigo.shared.ExistsId;
import br.com.zupacademy.achiley.casadocodigo.shared.UniqueValue;

public class LivroForm {
	
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;
	@NotBlank
	@Size(max = 500)
	private String resumo;
	@NotBlank
	private String sumario;
	@NotNull
	@Min(20)
	private BigDecimal preco;
	@NotNull
	@Min(100)
	private Integer numeroDePaginas;
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "ibsn")
	private String ibsn;
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate dataPublicacao;
	@NotNull
	@ExistsId(domainClass = Categoria.class)
	private Long categoriaId;
	@NotNull
	@ExistsId(domainClass = Autor.class)
	private Long autorId;
	
	@Deprecated
	public LivroForm() {
		
	}
	
	public LivroForm(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer numeroDePaginas, @NotBlank String ibsn,
			@Future LocalDate dataPublicacao, @NotNull Long categoriaId, @NotNull Long autorId) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroDePaginas = numeroDePaginas;
		this.ibsn = ibsn;
		this.dataPublicacao = dataPublicacao;
		this.categoriaId = categoriaId;
		this.autorId = autorId;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getNumeroDePaginas() {
		return numeroDePaginas;
	}

	public String getIbsn() {
		return ibsn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public Long getAutorId() {
		return autorId;
	}

	public Livro converter(EntityManager manager) {
		Autor autor = manager.find(Autor.class, autorId);
		Categoria categoria = manager.find(Categoria.class, categoriaId);
		return new Livro(titulo, resumo, sumario, preco, numeroDePaginas, ibsn, dataPublicacao, categoria, autor);
	}
}
