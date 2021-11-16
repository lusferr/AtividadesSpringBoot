package br.com.generation.minhaLojaDeGames.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.minhaLojaDeGames.Model.ModelUsuario;

@Repository
public interface RepositoryUsuario extends JpaRepository<ModelUsuario, Long>{
	
	public Optional<ModelUsuario> findByUsuario(String usuario);

}
