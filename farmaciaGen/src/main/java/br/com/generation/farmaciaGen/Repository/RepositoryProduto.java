package br.com.generation.farmaciaGen.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.farmaciaGen.model.ModelProduto;

@Repository
public interface RepositoryProduto extends JpaRepository<ModelProduto, Long>{
	public List<ModelProduto>findAllByNomeContainingIgnoreCase(String nome);
}
