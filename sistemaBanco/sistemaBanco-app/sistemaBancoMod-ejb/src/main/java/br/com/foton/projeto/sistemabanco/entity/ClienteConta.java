package br.com.foton.projeto.sistemabanco.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class ClienteConta extends Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3327315530388362376L;

	@EmbeddedId
	ClienteContaId id;

	@ManyToOne
	@JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", foreignKey = @ForeignKey(name = "ClienteConta_FK1"), insertable = false, updatable = false)
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "id_conta", referencedColumnName = "id_conta", foreignKey = @ForeignKey(name = "ClienteConta_FK2"), insertable = false, updatable = false)
	private Conta conta;

}