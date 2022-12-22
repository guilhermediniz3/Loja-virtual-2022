package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Produto;
import com.dev.backend.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	ProdutoRepository produtoRepository;
	
	public List<Produto> buscarTodos(){
		
	return produtoRepository.findAll();
		
		
	}
	
	public Produto inserir(Produto produto) {
		produto.setDataCriacao(new Date());
	   Produto produtoNovo = produtoRepository.saveAndFlush(produto);
	   return produtoNovo;
		
	}
	
	public Produto alterar(Produto objeto) {
		
		objeto.setDataAtualizacao(new Date());
		Produto produto = produtoRepository.saveAndFlush(objeto);
		return produto;
		
		
		
	}
	
	public void excluir(Long id) {
		
		Produto objeto = produtoRepository.findById(id).get();
		produtoRepository.delete(objeto);
		
		
	}
	

}
