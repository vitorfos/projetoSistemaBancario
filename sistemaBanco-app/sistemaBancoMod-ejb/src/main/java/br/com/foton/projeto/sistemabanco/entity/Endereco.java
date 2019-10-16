package br.com.foton.projeto.sistemabanco.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Endereco extends Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4405433499379678350L;
	
	@Id
	@Column (name = "id_endereco")
	private int idEndereco;
	@Column
	private String estado;
	@Column
	private String cidade;
	@Column
	private int cep;

}
