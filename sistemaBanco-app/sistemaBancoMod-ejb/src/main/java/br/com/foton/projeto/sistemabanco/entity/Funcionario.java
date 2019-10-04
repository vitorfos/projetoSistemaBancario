package br.com.foton.projeto.sistemabanco.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Funcionario extends Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2131431787114488991L;
	
	@Id
	@Column(name = "id_funcionario")
	private int idFuncionario;
	@Column
	private String setor;
	@Column(name = "tipo_funcionario")
	private String tipoFuncionario;

	// Conta tem a FK de Funcionario
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "funcionario")
	private Conta conta;

	// Funcionario tem a FK de Pessoa
	@Column(name = "id_pessoa")
	private int idPessoa;

	@OneToOne
	@JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa", foreignKey = @ForeignKey(name = "id_pessoaFK"), insertable = false, updatable = false)
	private Pessoa pessoa;
	
//	@Column 
//	private Funcionario funcionario; 
	
	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "funcionarios")
	//@JoinColumn(name="funcionarioFK", referencedColumnName="funcionario_id")
	//private List<Funcionario> funcionarios;
	

}
