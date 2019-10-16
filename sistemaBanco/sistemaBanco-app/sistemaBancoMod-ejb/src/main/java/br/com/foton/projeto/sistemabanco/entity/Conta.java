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
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Conta extends Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9089040123187910189L;

	@Id
	@Column(name = "id_conta")
	private int idConta;
	@Column
	private int numero;
	@Column
	private int agencia;
	@Column
	private double saldo;

	// Conta tem a FK de Funcionario
	@Column(name = "id_funcionario")
	private int idFuncionario;

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_funcionario", referencedColumnName = "id_funcionario", foreignKey = @ForeignKey(name = "id_funcionarioFK"), insertable = false, updatable = false)
	private Funcionario funcionario;

	public void setNumero(int numero) {
		if (numero > 0) {
			this.numero = numero;
		} else {
			System.out.println("Insira um número de conta válido");
		}
	}

}
