package br.com.foton.projeto.sistemabanco.enums;

public enum TipoFuncionario {

	GER("GERENTE"), OPE("OPERADOR");

	private String valor;

	private TipoFuncionario(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
}
