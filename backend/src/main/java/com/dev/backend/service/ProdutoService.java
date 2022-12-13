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
	
	public Produto insert(Produto produto) {
		produto.setDataCriacao(new Date());
	   Produto produtoNovo = produtoRepository.saveAndFlush(produto);
	   return produtoNovo;
		
	}

}
