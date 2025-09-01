package br.com.empresa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Teste {
	
	@RequestMapping("/oi") //endereço de onde esta ou pra onde vai/recurso
	public String mensagem() {
		return "Hello World!";
	}

	@RequestMapping("/msg")
	public String converter (@RequestParam String texto) { //metodo
		return texto.toUpperCase();
	}
}
