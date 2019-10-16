package br.com.foton.projeto.sistemabanco.enums;

public enum TipoOperacao {

	CRED("Credito"), DEB("Debito"), TRANSF("Transferencia");

	private String tipoOperacao;

	private TipoOperacao(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public String getTipoOperacao() {
		return tipoOperacao;
	}

}
