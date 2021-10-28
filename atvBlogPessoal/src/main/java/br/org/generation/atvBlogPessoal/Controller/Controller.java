package br.org.generation.atvBlogPessoal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.atvBlogPessoal.Repository.PostagemRepository;
import br.org.generation.atvBlogPessoal.model.AtvBlogPessoalModel;

@RestController
@RequestMapping("/blogpessoal")
@CrossOrigin("*")
public class Controller {
	
	@Autowired
	private PostagemRepository postagemrepository;
	
	@GetMapping
	public ResponseEntity<List<AtvBlogPessoalModel>> GetAll(){
		return ResponseEntity.ok(postagemrepository.findAll());
	}

}
