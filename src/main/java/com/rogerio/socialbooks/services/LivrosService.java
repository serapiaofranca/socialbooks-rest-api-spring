package com.rogerio.socialbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rogerio.socialbooks.domain.Livro;
import com.rogerio.socialbooks.repository.LivrosRepository;
import com.rogerio.socialbooks.services.exception.LivroNaoEncontradoException;

@Service
public class LivrosService {
	
	@Autowired
	private LivrosRepository livrosRepository;
	
	public List<Livro> listar(){
		return livrosRepository.findAll();
	}
	
	public Livro buscar(Long id) {
		
		Livro livro = livrosRepository.findById(id).orElse(null);
		
		if (livro == null) {
			throw new LivroNaoEncontradoException("Livro não encontrado...");
		}
		
		return livro;
	}
	
	public Livro salvar(Livro livro) {
		livro.setId(null);
		return livrosRepository.save(livro);
	}
	
	public void deletar(Long id) {
		try {
			livrosRepository.deleteById(id);
		} catch (LivroNaoEncontradoException e) {
			throw new LivroNaoEncontradoException("livro nao encontrado");
		}
	}
	
	public void atualizar(Livro livro) {
		verificarExistencia(livro);
		livrosRepository.save(livro);		
	}
	
	private void verificarExistencia(Livro livro) {
		buscar(livro.getId());
	}

}
