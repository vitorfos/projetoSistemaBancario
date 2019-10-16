package br.com.foton.projeto.sistemabanco.enums;

public enum Titularidade {

	TIT("Titular"), DEP("Dependente");

	private String valor;

	private Titularidade(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return this.valor;
	}

}
