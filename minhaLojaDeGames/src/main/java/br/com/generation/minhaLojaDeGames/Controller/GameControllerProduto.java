package br.com.generation.minhaLojaDeGames.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.generation.minhaLojaDeGames.Model.GameModelProduto;
import br.com.generation.minhaLojaDeGames.Repository.GameRepositoryProduto;

@RestController
@RequestMapping("/produto")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class GameControllerProduto {
	
	@Autowired
	private GameRepositoryProduto produtoRepository;
	
	@GetMapping
	public ResponseEntity<List<GameModelProduto>> getAll() {
		return ResponseEntity.ok(produtoRepository.findAll()); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GameModelProduto> getById (@PathVariable long id){
		return produtoRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<GameModelProduto>> getByTituloString(@PathVariable String titulo){
		return ResponseEntity.ok(produtoRepository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping
	public ResponseEntity<GameModelProduto> post (@RequestBody GameModelProduto produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<GameModelProduto> put (@RequestBody GameModelProduto produto){
		return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		produtoRepository.deleteById(id);
	}

}
