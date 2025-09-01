package br.com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.empresa.entity.Veiculo;
import br.com.empresa.repository.VeiculoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
	
	@Autowired
   private VeiculoRepository repository;
   
   @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
   public Veiculo inserir(@Valid @RequestBody Veiculo v) {
	   return repository.save(v);
   }
   
   @GetMapping
   public List<Veiculo> listar(){
	   return repository.findAll();
   }
   

}
