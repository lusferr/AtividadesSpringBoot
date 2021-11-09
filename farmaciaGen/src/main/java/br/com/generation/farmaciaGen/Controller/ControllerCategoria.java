package br.com.generation.farmaciaGen.Controller;

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

import br.com.generation.farmaciaGen.Repository.RepositoryCategoria;
import br.com.generation.farmaciaGen.model.ModelCategoria;

@RestController
@RequestMapping("/categorias")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class ControllerCategoria {
	
	@Autowired
	private RepositoryCategoria categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<ModelCategoria>> getAll() {
		return ResponseEntity.ok(categoriaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ModelCategoria> getById (@PathVariable long id) {
		return categoriaRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<ModelCategoria>> getByDescricao (@PathVariable String descricao){
		return ResponseEntity.ok(categoriaRepository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	@PostMapping
	public ResponseEntity<ModelCategoria> post (@RequestBody ModelCategoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<ModelCategoria> put (@RequestBody ModelCategoria categoria) {
		return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(categoria));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		categoriaRepository.deleteById(id);
	}

}

