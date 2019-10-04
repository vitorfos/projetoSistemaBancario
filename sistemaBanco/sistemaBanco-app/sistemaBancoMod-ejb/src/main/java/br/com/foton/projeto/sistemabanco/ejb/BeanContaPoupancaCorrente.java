package br.com.foton.projeto.sistemabanco.ejb;

import javax.ejb.Stateless;

import br.com.foton.projeto.sistemabanco.constantes.Constante;
import br.com.foton.projeto.sistemabanco.entity.Conta;
import br.com.foton.projeto.sistemabanco.negocio.OperacaoServico;

@Stateless
public class BeanContaPoupancaCorrente extends BeanConta {

	private static final long serialVersionUID = -4304726078724448172L;
	
	@Override
	public Conta debito(double valor, Conta conta) {
		try {
			if (conta.getSaldo() >= valor && valor > 0) {
				conta.setSaldo((conta.getSaldo() - (valor * Constante.TX_OP_DEBITO_CONTA_POUP_CORRENTE)));
			} else {
				System.out.println("A conta não possui saldo suficiente para realizar a transferência.");
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return conta;
	}
	
	@Override
	public Conta credito(double valor, Conta conta) {
		try {
			double bonificacaoVariavelCredito = OperacaoServico.bonificacaoVariavelCredito(valor);
			super.credito(bonificacaoVariavelCredito, conta);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conta;
	}

}
