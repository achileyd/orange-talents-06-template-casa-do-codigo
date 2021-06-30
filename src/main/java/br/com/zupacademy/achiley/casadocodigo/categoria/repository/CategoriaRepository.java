package br.com.zupacademy.achiley.casadocodigo.categoria.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.achiley.casadocodigo.categoria.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long>{
	Optional<Categoria> findByNome(String nome);
}
