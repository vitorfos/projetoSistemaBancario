package br.com.foton.projeto.sistemabanco.enums;

public enum TipoPessoa {

	F("Fisica"), J("Juridica");

	private String valor;

	private TipoPessoa(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
}
