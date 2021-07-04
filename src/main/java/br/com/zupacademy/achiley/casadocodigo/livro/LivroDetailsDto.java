package br.com.zupacademy.achiley.casadocodigo.livro;

import java.math.BigDecimal;

public class LivroDetailsDto {
	
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer numeroDePaginas;
	private String ibsn;
	private String nomeAutor;
	
	public LivroDetailsDto(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numeroDePaginas = livro.getNumeroDePaginas();
		this.ibsn = livro.getIbsn();
		this.nomeAutor = livro.getAutor().getNome();
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

	public String getNomeAutor() {
		return nomeAutor;
	}
	
}
