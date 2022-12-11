package com.dev.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.entity.Cidade;
import com.dev.backend.service.CidadeService;

@RestController
@RequestMapping("/api/cidade")
public class CidadeController {
	@Autowired
	CidadeService cidadeService;
	@GetMapping("/")
	public List<Cidade> buscarTodos(){
		return cidadeService.buscarTodos();
		
		
	}
	@PostMapping("/")
	public Cidade inserir(@RequestBody Cidade ojeto) {
		return cidadeService.inserir(ojeto);
		
		
	}
	@PutMapping("/")
	public Cidade alterar(@RequestBody Cidade objeto) {
		return cidadeService.update(objeto);
	}
	public ResponseEntity<Void>deletar(Long id){
		cidadeService.deletar(id);
		return ResponseEntity.ok().build();
	}

}
