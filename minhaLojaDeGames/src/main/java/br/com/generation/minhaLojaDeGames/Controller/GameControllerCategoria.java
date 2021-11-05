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

import br.com.generation.minhaLojaDeGames.Model.GameModelCategoria;
import br.com.generation.minhaLojaDeGames.Repository.GameRepositoryCategoria;

@RestController
@RequestMapping("/categoria")
@CrossOrigin (origins = "*", allowedHeaders = "*") //orgiem da requisição
public class GameControllerCategoria {

	@Autowired
	private GameRepositoryCategoria categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<GameModelCategoria>> getAll() { //SELECT * FROM tb_categoria
		return ResponseEntity.ok(categoriaRepository.findAll()); //http 200-299
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GameModelCategoria> getById (@PathVariable long id){
		return categoriaRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/genero/{genero}")
	public ResponseEntity<List<GameModelCategoria>> getByGeneroString(@PathVariable String genero){
		return ResponseEntity.ok(categoriaRepository.findAllByGeneroContainingIgnoreCase(genero)); //findAllByGeneroContainingIgnoreCase
	}
	
	@PostMapping
	public ResponseEntity<GameModelCategoria> post (@RequestBody GameModelCategoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<GameModelCategoria> put (@RequestBody GameModelCategoria categoria){
		return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(categoria));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		categoriaRepository.deleteById(id);
	}
	
}
