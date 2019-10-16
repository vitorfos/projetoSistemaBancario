package br.com.foton.projeto.sistemabanco.enums;

public enum TipoOperacao {

	CRED("Credito"), DEB("Debito"), TRANSF("Transferencia");

	private String valor;

	private TipoOperacao(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

}
