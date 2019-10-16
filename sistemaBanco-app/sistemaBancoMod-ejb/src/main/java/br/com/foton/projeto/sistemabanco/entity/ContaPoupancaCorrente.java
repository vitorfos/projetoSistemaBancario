package br.com.foton.projeto.sistemabanco.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.foton.projeto.sistemabanco.enums.BloqueioConta;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ContaPoupancaCorrente extends Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6374076958200004281L;
	
	@Id
	private int id_contaPoupancaCorrente;
	@Column (name = "cheque_especial")
	private String chequeEspecial;
	@Column (name = "tipo_conta")
	private String tipoConta;

	@Enumerated (EnumType.STRING)
	private BloqueioConta bloqueio; 
	
	//Conta Poupanca Corrente tem a FK de Conta
	@Column(name = "id_conta")
	private int idConta;

	@OneToOne
	@JoinColumn(name = "id_conta", referencedColumnName = "id_conta", foreignKey = @ForeignKey(name = "id_contaFK"), insertable = false, updatable = false)
	private Conta conta;

}
