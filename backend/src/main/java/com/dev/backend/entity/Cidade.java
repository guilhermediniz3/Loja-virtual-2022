package com.dev.backend.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Table
@Entity(name="cidade")
@Data
public class Cidade {
	@Id
  @GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	public String nome;
	@ManyToOne
	@JoinColumn(name="idEstado")
	private Estado estado;
  @Temporal(TemporalType.TIMESTAMP)
	public Date dataCriacao;
  @Temporal(TemporalType.TIMESTAMP)
	public Date dataAtualizacao;

}
