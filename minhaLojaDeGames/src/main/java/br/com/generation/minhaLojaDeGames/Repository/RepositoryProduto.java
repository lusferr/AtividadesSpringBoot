package br.com.generation.minhaLojaDeGames.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.minhaLojaDeGames.Model.ModelProduto;

@Repository
public interface RepositoryProduto extends JpaRepository<ModelProduto, Long>{
	public List<ModelProduto>findAllByTituloContainingIgnoreCase(String titulo);
}
