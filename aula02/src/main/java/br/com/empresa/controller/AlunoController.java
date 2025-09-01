package br.com.empresa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.empresa.domain.Aluno;

@RestController 
@RequestMapping ("/alunos")
public class AlunoController {
	private static List<Aluno> alunos = new ArrayList<>();
	
	static { //quando inicializar vai abir isso primeiro, essa é uma lista em memoria
		alunos.add(new Aluno("123","José","j@gmail.com"));
		alunos.add(new Aluno("124","Igor","i@gmail.com"));
		alunos.add(new Aluno("125","Maria","m@gmail.com"));
	}
	
	@GetMapping
   public List<Aluno> listar(){
	   return alunos;
   }
	@GetMapping("{matricula}")  //procurar pela matricula
	public Aluno buscarAluno(@PathVariable String matricula) {
		for (int i = 0; i < alunos.size(); i++) { //use index on array
			if (alunos.get(i).getMatricula().equals(matricula)) {
				return alunos.get(i);
			}
			
		}
		return null;
		
	}
	@PostMapping // cadastrar alunos
	public Aluno inserir(@RequestBody Aluno aluno) {
		alunos.add(aluno);
		return aluno;
	}
}
