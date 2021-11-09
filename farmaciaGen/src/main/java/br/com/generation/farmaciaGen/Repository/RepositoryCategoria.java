package br.com.generation.farmaciaGen.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.farmaciaGen.model.ModelCategoria;

@Repository
public interface RepositoryCategoria extends JpaRepository<ModelCategoria, Long>{
	public List<ModelCategoria>findAllByDescricaoContainingIgnoreCase(String descricao);
	// criar outro tipo de localizador public Lis
}
