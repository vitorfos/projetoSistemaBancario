package br.com.foton.projeto.sistemabanco.negocio;

import br.com.foton.projeto.sistemabanco.constantes.Constante;

public class OperacaoServico {

	public static double bonificacaoVariavelCredito(double valor) {
		if (valor > Constante.ZERO && valor <= Constante.MIL_REAIS) {
			valor = (valor * Constante.BONUS_OP_CREDITO_MIL);
		} else if (valor > Constante.MIL_REAIS && valor <= Constante.CEM_MIL_REAIS) {
			valor = (valor * Constante.BONUS_OP_CREDITO_CEM_MIL);
		} else {
			valor = (valor * Constante.BONUS_OP_CREDITO_ALTOS_VALORES);
		}
		return valor;
	}
}
