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
public class Conta extends Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9089040123187910189L;
	
	@Id
	private int id_conta;
	@Column
	private int numero;
	@Column
	private int agencia;
	@Column
	private double saldo;

	// Conta tem a FK de Funcionario
	@Column(name = "id_funcionario")
	private int idFuncionario;

	@OneToOne
	@JoinColumn(name = "id_funcionario", referencedColumnName = "id_funcionario", foreignKey = @ForeignKey(name = "id_funcionarioFK"), insertable = false, updatable = false)
	private Funcionario funcionario;

	// Conta Poupanca Corrente e Conta Salario tem a FK de Conta
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "conta")
	private ContaPoupancaCorrente contaPoupancaCorrente;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "conta")
	private ContaSalario contaSalario;

	// ClienteConta tem a FK de Conta
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "conta")
	private List<ClienteConta> clienteConta;

}
