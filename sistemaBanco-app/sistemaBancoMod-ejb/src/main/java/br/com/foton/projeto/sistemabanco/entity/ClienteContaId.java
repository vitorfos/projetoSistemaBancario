package br.com.foton.projeto.sistemabanco.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode(callSuper = false)
public class ClienteContaId extends Entidade {

	private static final long serialVersionUID = 268577956817550686L;

	@Column(name = "id_cliente")
	private String idCliente;

	@Column(name = "id_conta")
	private String idConta;
}