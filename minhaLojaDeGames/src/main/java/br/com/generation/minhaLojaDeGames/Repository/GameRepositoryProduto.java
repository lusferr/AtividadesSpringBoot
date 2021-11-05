package br.com.generation.minhaLojaDeGames.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.minhaLojaDeGames.Model.GameModelProduto;

@Repository
public interface GameRepositoryProduto extends JpaRepository<GameModelProduto, Long>{
	public List<GameModelProduto>findAllByTituloContainingIgnoreCase(String titulo);
}
