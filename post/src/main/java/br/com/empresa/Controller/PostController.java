package br.com.empresa.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.empresa.entity.Post;
import br.com.empresa.repository.PostRepository;

@RestController
@RequestMapping("/posts")
public class PostController {

	 @Autowired
	private PostRepository repository;
	 
	 //inserir item
	 @PostMapping
	 @ResponseStatus(HttpStatus.CREATED)
	 public Post inserir(@RequestBody Post p) {
		 return repository.save(p); 
	 }
	 
	 //listar item
	 @GetMapping
	 public List<Post>listar(){
		 return repository.findAll();
	 }
	 
	 //buscar item pelo seu id
	 @GetMapping("{id}")
		public ResponseEntity<Post> buscar(@PathVariable Long id) {
			Optional<Post> post = repository.findById(id);
			if (post.isPresent()) {
				return ResponseEntity.ok(post.get());
			}
			return ResponseEntity.notFound().build();
		}
	 
	 //deletar item
	 @DeleteMapping("{id}")
		public ResponseEntity<Void> apagar(@PathVariable Long id) {
			if (repository.existsById(id)) {
				repository.deleteById(id);
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.notFound().build();
		}
	 
	 //alerar item
		@PutMapping("{id}")
		public ResponseEntity<Post> alterar
		(@PathVariable Long id, @RequestBody Post p) {
			Optional<Post> post = repository.findById(id);
			if (post.isPresent()) {
				p.setId(id);
			return ResponseEntity.ok(repository.save(p));
			}
			return ResponseEntity.notFound().build();
		}
	 
	 }
	 


