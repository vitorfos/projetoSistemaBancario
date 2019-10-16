package br.com.foton.projeto.sistemabanco.entity;

import br.com.foton.projeto.sistemabanco.entity.Conta;
import br.com.foton.projeto.sistemabanco.entity.Entidade;
import br.com.foton.projeto.sistemabanco.enums.TipoOperacao;
import lombok.Getter;
import lombok.Setter;

//anotar como entidade
@Getter
@Setter
@SuppressWarnings("unused")
public class Transacao extends Entidade{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5339287656514679370L;
	
	//id auto generate
	private int idTransacao;
	//fk de conta
	private int idContaOrigem;
	//fk de conta
	private int idContaDestino;
	//valor da transacao
	private double valorTransacao;
	//enum que define o tipo da operacao
	private TipoOperacao tipoOperacao;
	
}