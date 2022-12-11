package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Cidade;
import com.dev.backend.repository.CidadeRepository;

@Service
public class CidadeService {
	@Autowired
	CidadeRepository cidadeRepository;
	
	public List<Cidade> buscarTodos() {
		return cidadeRepository.findAll();
	}
	
	public Cidade inserir(Cidade objeto) {
		objeto.setDataCriacao(new Date());
		Cidade objetoNovo = cidadeRepository.saveAndFlush(objeto);
		return objetoNovo;
	}
	public Cidade update(Cidade objeto) {
		objeto.setDataAtualizacao(new Date());
		Cidade objetoUpdate = cidadeRepository.saveAndFlush(objeto);
		return objetoUpdate;
	}
	
	public void deletar(Long id) {
		Cidade objeto = cidadeRepository.findById(id).get();
		cidadeRepository.delete(objeto);
		
		
	}
	
}
