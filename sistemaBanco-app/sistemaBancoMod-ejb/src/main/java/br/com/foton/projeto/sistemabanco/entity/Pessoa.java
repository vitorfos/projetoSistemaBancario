package br.com.foton.projeto.sistemabanco.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.foton.projeto.sistemabanco.enums.TipoPessoa;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pessoa extends Entidade{

	
	private static final long serialVersionUID = -7673541242396005106L;
	
	@Id 
	@Column (name = "id_pessoa")
	private int idPessoa;
	@Column
	private String nome;
	@Column (name = "tipo_pessoa")
	@Enumerated (EnumType.STRING)
	private TipoPessoa tipoPessoa;
	@Column
	private int rg;
	@Column
	private int cpf;
	@Column
	private int cnpj;
	
	//Funcionario tem a FK de Pessoa
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "pessoa")
	private Funcionario funcionario;
	

	//Pessoa tem a FK de Endereco
	@Column (name="id_endereco")
	private int idEndereco;
	
	@OneToOne
	@JoinColumn (name = "id_endereco", referencedColumnName = "id_endereco", foreignKey = @ForeignKey(name = "id_enderecoFK"), insertable = false, updatable = false)
	private Endereco endereco;

}
