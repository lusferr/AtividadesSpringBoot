package br.com.generation.minhaLojaDeGames.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.minhaLojaDeGames.Model.GameModelCategoria;

@Repository
public interface GameRepositoryCategoria extends JpaRepository<GameModelCategoria, Long>{
	public List<GameModelCategoria>findAllByGeneroContainingIgnoreCase(String genero);
}
