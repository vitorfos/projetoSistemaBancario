package br.com.foton.projeto.sistemabanco.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.foton.projeto.sistemabanco.enums.BloqueioConta;
import br.com.foton.projeto.sistemabanco.util.BloqueioContaConversor;
import br.com.foton.projeto.sistemabanco.util.TipoContaConversor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class ContaPoupancaCorrente extends Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6374076958200004281L;

	@Id
	private int id_contaPoupancaCorrente;
	@Column(name = "cheque_especial")
	private String chequeEspecial;

	@Convert(converter = TipoContaConversor.class)
	@Column(name = "tipo_conta")
	private String tipoConta;

	@Convert(converter = BloqueioContaConversor.class)
	@Column(name = "bloqueio")
	private BloqueioConta bloqueio;

	// Conta Poupanca Corrente tem a FK de Conta
	@Column(name = "id_conta")
	private int idConta;

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_conta", referencedColumnName = "id_conta", foreignKey = @ForeignKey(name = "id_contaFK"), insertable = false, updatable = false)
	private Conta conta;

}
