package br.com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.empresa.entity.Produto;
import br.com.empresa.repository.ProdutoRepository;



@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;
	
	
	@PostMapping
	public Produto inserir(@RequestBody Produto p){
		return repository.save(p);
	}
	
	@GetMapping
	public List<Produto> listar(){
		return repository.findAll();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Produto> buscarProduto(@PathVariable Long id) {
		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(repository.findById(id).get());
	}

	@PutMapping("{id}")
	public ResponseEntity<Produto> alterarProduto(@PathVariable Long id,@RequestBody Produto p ) {
		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		p.setId(id);
		return ResponseEntity.ok(repository.save(p));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void>apagar(@PathVariable Long id){
		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		repository.deleteById(id);
		return ResponseEntity.noContent().build();

 }
}










