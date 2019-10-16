package br.com.foton.projeto.sistemabanco.enums;

public enum BloqueioConta {

	BT("BLOQUEIO_TOTAL"), BC("BLOQUEIO_CREDITO"), BD("BLOQEUIO_DEBITO");

	private String valor;

	private BloqueioConta(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
}
