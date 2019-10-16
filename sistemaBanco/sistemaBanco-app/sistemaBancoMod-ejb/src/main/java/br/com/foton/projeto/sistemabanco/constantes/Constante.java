package br.com.foton.projeto.sistemabanco.constantes;

public class Constante {

	// Constantes utilizadas nas operaçoes de debito das contas poupancaCorrente e
	// salário

	// Mudei os valores das taxas para 0,2% e 0,5%
	public static final double TX_OP_DEBITO_CONTA_POUP_CORRENTE = 1.005;
	public static final double TX_OP_DEBITO_CONTA_SALARIO = 1.002;

	// Constantes utilizadas nas operações de crédito da conta poupancaCorrente

	// Bonus
	public static final double BONUS_OP_CREDITO_MIL = 1.05;
	public static final double BONUS_OP_CREDITO_CEM_MIL = 1.04;
	public static final double BONUS_OP_CREDITO_ALTOS_VALORES = 1.01;

	// Valores
	public static final int ZERO = 0;
	public static final int MIL_REAIS = 1000;
	public static final int CEM_MIL_REAIS = 100000;

}
