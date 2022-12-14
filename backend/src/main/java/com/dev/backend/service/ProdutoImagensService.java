package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.ProdutoImagens;
import com.dev.backend.repository.ProdutoImagensRepository;

@Service
public class ProdutoImagensService {
	@Autowired
	ProdutoImagensRepository produtoImagensRepository;
	
	public List<ProdutoImagens> buscarTodos(){
		return produtoImagensRepository.findAll();
	}
	
	public ProdutoImagens inserir(ProdutoImagens objeto) {
	
		objeto.setDataCriacao(new Date());
		ProdutoImagens objetoNovo = produtoImagensRepository.saveAndFlush(objeto);
		return objetoNovo;
	}
	
	public ProdutoImagens alterar(ProdutoImagens objeto) {
		
		objeto.setDataCriacao(new Date());
		ProdutoImagens objetoNovo = produtoImagensRepository.saveAndFlush(objeto);
		return objetoNovo;
		
		
		
	}
	
	public void deletar(Long id) {
		ProdutoImagens imagem = produtoImagensRepository.findById(id).get();
		produtoImagensRepository.delete(imagem);
	}

}
