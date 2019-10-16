package br.com.foton.projeto.sistemabanco.enums;

public enum TipoConta {

	CS("CONTA_SALARIO"), CPC("CONTA_POUPANCA_CORRENTE");

	private String valor;

	private TipoConta(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
}
