package br.com.zupacademy.achiley.casadocodigo.localizacao.estado;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
	
	Optional<Estado> findByNomeAndPaisId(String nome, Integer paisId);
}
