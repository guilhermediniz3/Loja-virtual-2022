package com.dev.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.backend.entity.Estado;
@Repository
public interface EstadoRepository  extends JpaRepository<Estado , Long>{
  
}
