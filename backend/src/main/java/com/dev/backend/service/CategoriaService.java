package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Categoria;
import com.dev.backend.entity.Estado;
import com.dev.backend.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public List<Categoria> buscarTodos(){
		return categoriaRepository.findAll();
	}
	public Categoria inserir(Categoria categoria) {
		categoria.setDataCriacao(new Date());
		Categoria categoriaNova = categoriaRepository.saveAndFlush(categoria);
		return categoriaNova;
	}
	
	public Categoria alterar(Categoria categoria) {
		
		categoria.setDataAtualizacao(new Date());
	  
	Categoria categoriaUpdate = categoriaRepository.saveAndFlush(categoria);
		return categoriaUpdate;
	
	}
	
	public void deletar(Long id) {
		Categoria categoria = categoriaRepository.findById(id).get();
		 categoriaRepository.delete(categoria);
		
	}
		
}
