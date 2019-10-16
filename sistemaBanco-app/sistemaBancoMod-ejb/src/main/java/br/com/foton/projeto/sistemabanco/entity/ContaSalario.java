package br.com.foton.projeto.sistemabanco.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.foton.projeto.sistemabanco.util.TipoContaConversor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class ContaSalario extends Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5468087447826558982L;

	@Id
	@Column(name = "id_contaSalario")
	private int idContaSalario;

	@Convert(converter = TipoContaConversor.class)
	@Column(name = "tipo_conta")
	private String tipoConta;

	@Column
	private Boolean isAtivo;

	// Conta salário tem a FK de conta
	@Column(name = "id_conta")
	private int idConta;

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_conta", referencedColumnName = "id_conta", foreignKey = @ForeignKey(name = "id_contaSFK"), insertable = false, updatable = false)
	private Conta conta;

}
