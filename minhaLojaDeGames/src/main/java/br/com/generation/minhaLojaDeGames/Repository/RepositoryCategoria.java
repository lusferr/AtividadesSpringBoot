package br.com.generation.minhaLojaDeGames.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.minhaLojaDeGames.Model.ModelCategoria;

@Repository
public interface RepositoryCategoria extends JpaRepository<ModelCategoria, Long>{
	public List<ModelCategoria>findAllByGeneroContainingIgnoreCase(String genero);
}
