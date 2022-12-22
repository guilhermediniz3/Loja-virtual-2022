package com.dev.backend.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Table(name = "pessoa")
@Data
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String Endereco;
	private String cep;
	@ManyToOne
	@JoinColumn(name = "idCidade")
	private Cidade cidade;
	@OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, fetch = FetchType.EAGER)
	@Setter(value = AccessLevel.NONE)

	private List<PermissaoPessoa> permissaoPessoa;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtualizacao;

	public void setPermissaoPessoas(List<PermissaoPessoa> pp) {
		for (PermissaoPessoa p : pp) {
			p.setPessoa(this);
		}
		this.permissaoPessoa = pp;
	}

}