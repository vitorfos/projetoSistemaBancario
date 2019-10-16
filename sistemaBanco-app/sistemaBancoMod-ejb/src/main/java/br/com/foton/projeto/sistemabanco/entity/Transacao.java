package br.com.foton.projeto.sistemabanco.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.foton.projeto.sistemabanco.entity.Conta;
import br.com.foton.projeto.sistemabanco.entity.Entidade;
import br.com.foton.projeto.sistemabanco.enums.TipoOperacao;
import br.com.foton.projeto.sistemabanco.util.TipoOperacaoConversor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@SuppressWarnings("unused")
public class Transacao extends Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5339287656514679370L;

	@Id
	@Column(name = "id_transacao")
	private int idTransacao;

	@Column(name = "numero_contaOrigem")
	private int numeroContaOrigem;

	@Column(name = "numero_contaDestino")
	private int numeroContaDestino;

	@Column(name = "valor")
	private double valorTransacao;

	@Convert(converter = TipoOperacaoConversor.class)
	@Column(name = "tipo_operacao")
	private TipoOperacao tipoOperacao;

	// Transacao tem a FK de conta (para contaOrigem)
	@Column(name = "id_contaOrigem", nullable = true)
	private int idContaOrigem;

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_contaOrigem", referencedColumnName = "id_conta", foreignKey = @ForeignKey(name = "id_contaOrigemFK"), insertable = false, updatable = false)
	private Conta contaOrigem;

	// Transacao tem a FK de conta (para contaDestino)
	@Column(name = "id_contaDestino", nullable = true)
	private int idContaDestino;

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_contaDestino", referencedColumnName = "id_conta", foreignKey = @ForeignKey(name = "id_contaDestinoFK"), insertable = false, updatable = false)
	private Conta contaDestino;

}