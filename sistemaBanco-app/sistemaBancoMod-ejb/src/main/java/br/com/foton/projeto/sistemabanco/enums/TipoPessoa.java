package br.com.foton.projeto.sistemabanco.enums;

public enum TipoPessoa {

	F("Fisica"), J("Juridica");

	private String tipoPessoa;

	private TipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}
}
