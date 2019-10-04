package br.com.foton.projeto.sistemabanco.enums;

public enum TipoConta {

	CS("CONTA_SALARIO"), CPC("CONTA_POUPANCA_CORRENTE");

	private String tipoConta;

	private TipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getTipoConta() {
		return tipoConta;
	}
}
