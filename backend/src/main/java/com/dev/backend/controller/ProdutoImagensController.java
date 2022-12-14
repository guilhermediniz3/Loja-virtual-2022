package com.dev.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.entity.ProdutoImagens;
import com.dev.backend.service.ProdutoImagensService;

@RestController
@RequestMapping("produtoimagens")
public class ProdutoImagensController {
	@Autowired
	ProdutoImagensService produtoImagensService;
	@GetMapping("/")
	public List<ProdutoImagens> buscarTodos(){
		
		return produtoImagensService.buscarTodos();
		
		
	}
	@PostMapping("/")
	public ProdutoImagens inserir(@RequestBody ProdutoImagens objeto) {
		
		return produtoImagensService.inserir(objeto);
		
		
	}
	@PutMapping("/")
	public ProdutoImagens alterar(@RequestBody ProdutoImagens objeto) {
		
		return produtoImagensService.alterar(objeto);
		
	}
	
	@DeleteMapping("/")
	public ResponseEntity<ProdutoImagens>	deletar(@PathVariable Long id){
		
		produtoImagensService.deletar(id);
		return ResponseEntity.ok().build();
		
	}

}
