package br.com.zupacademy.achiley.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.achiley.casadocodigo.autor.Autor;
import br.com.zupacademy.achiley.casadocodigo.categoria.Categoria;

@Entity
@Table(name = "livros")
public class Livro {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
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
	private String ibsn;
	@Future
	private LocalDate dataPublicacao;
	@NotNull
	@ManyToOne
	private Categoria categoria;
	@NotNull
	@ManyToOne
	private Autor autor;
	
	@Deprecated
	public Livro() {
		
	}
	
	public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer numeroDePaginas, @NotBlank String ibsn,
			@Future LocalDate dataPublicacao, @NotNull Categoria categoria, @NotNull Autor autor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroDePaginas = numeroDePaginas;
		this.ibsn = ibsn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}

	public Long getId() {
		return id;
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

	public Autor getAutor() {
		return autor;
	}

	@Override
	public String toString() {
		return "Livro [\nTitulo = " + titulo + 
				" \nResumo = " + resumo +
				" \nSumario = " + sumario +
				" \nPreco = "+ preco +
				" \nNumero de paginas = " + numeroDePaginas +
				" \nIbsn = " + ibsn +
				" \nData de Publicacao = " + dataPublicacao +
				" \nCategoria = "+ categoria.getNome() + 
				" \nAutor = " + autor.getNome() + "\n]";
	}

}
