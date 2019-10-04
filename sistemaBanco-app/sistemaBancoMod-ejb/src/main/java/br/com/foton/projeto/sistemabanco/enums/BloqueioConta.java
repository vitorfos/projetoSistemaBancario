package br.com.foton.projeto.sistemabanco.enums;

public enum BloqueioConta {

	BT("BLOQUEIO_TOTAL"), BC("BLOQUEIO_CREDITO"), BD("BLOQEUIO_DEBITO");

	private String bloqueio;

	private BloqueioConta(String bloqueio) {
		this.bloqueio = bloqueio;
	}

	public String getBloqueio() {
		return bloqueio;
	}
}
