package br.com.foton.projeto.sistemabanco.ejb;

import javax.ejb.Stateless;

import br.com.foton.projeto.sistemabanco.constantes.Constante;
import br.com.foton.projeto.sistemabanco.entity.Conta;

@Stateless
public class BeanContaSalario extends BeanConta {

	private static final long serialVersionUID = -5428061635036848588L;
	
	@Override
	public Conta debito(double valor, Conta conta) {
		try {
			if (conta.getSaldo() >= valor) {
				conta.setSaldo((conta.getSaldo() - (valor * Constante.TX_OP_DEBITO_CONTA_SALARIO)));
			} else {
				System.out.println("A conta não possui saldo suficiente para realizar a transferência.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conta;
	}

}
