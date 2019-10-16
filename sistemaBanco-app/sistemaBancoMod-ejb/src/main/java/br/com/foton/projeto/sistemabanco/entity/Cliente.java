package br.com.foton.projeto.sistemabanco.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cliente extends Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8006215540980746248L;
	
	@Id 
	@Column (name = "id_cliente")
	private int idCliente;
	@Column
	private String titularidade;

	//Cliente tem a FK de Pessoa
	@Column (name = "id_pessoa")
	private int idPessoa;
	
	@OneToOne
	@JoinColumn (name = "id_pessoa", referencedColumnName = "id_pessoa", foreignKey = @ForeignKey(name = "id_pessoaFK1"), insertable = false, updatable = false)
	private Pessoa pessoa;
	
	//ClienteConta tem a FK de Cliente
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private List<ClienteConta> clienteConta;
}
