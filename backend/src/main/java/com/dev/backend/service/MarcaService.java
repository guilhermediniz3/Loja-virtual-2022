package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Marca;
import com.dev.backend.repository.MarcaRepository;



@Service
public class MarcaService {
@Autowired
MarcaRepository marcaRepository;


public List<Marca> buscarTodos(){

return  marcaRepository.findAll();


}


public Marca inserir(Marca marca){
marca.setDataCriacao(new Date());
Marca marcaNova = marcaRepository.saveAndFlush(marca);
return marcaNova;
}

public Marca alterar(Marca marca){
marca.setDataAtualizacao(new Date());
  Marca  marcaUpdate = marcaRepository.saveAndFlush(marca);
  return marcaUpdate;
}

public  void deletar(Long id){
  Marca marca = marcaRepository.findById(id).get();
  marcaRepository.delete(marca);
  
   
}
  
}
