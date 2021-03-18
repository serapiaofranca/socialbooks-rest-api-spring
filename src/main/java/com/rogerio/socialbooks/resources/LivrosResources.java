package com.rogerio.socialbooks.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rogerio.socialbooks.domain.Livro;

@RestController
public class LivrosResources {
	
	@RequestMapping(value = "/livros", method = RequestMethod.GET)
	public List<Livro> listar() {
		
		Livro livro1 = new Livro("Spring Boot Avançaco");
		Livro livro2 = new Livro("Rest API com Spring MVC");
		Livro[] livros= {livro1, livro2};
		
		return Arrays.asList(livros);
	}

}
