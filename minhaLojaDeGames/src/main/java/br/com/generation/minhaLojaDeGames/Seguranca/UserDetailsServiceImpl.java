package br.com.generation.minhaLojaDeGames.Seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.generation.minhaLojaDeGames.Model.ModelUsuario;
import br.com.generation.minhaLojaDeGames.Repository.RepositoryUsuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private RepositoryUsuario userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<ModelUsuario> user = userRepository.findByUsuario(userName);
		user.orElseThrow(() -> new UsernameNotFoundException(userName + "not found."));
		
		return user.map(UserDetailsImpl:: new).get();
		
	}

}
