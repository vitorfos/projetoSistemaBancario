package br.com.foton.projeto.sistemabanco.ejb;

import java.io.Serializable;

import br.com.foton.projeto.sistemabanco.entity.Conta;

public abstract class BeanConta implements Serializable {

	private static final long serialVersionUID = -1242388914027391591L;

	public Conta credito(double valor, Conta conta) {
		try {
			if (valor > 0) {
				conta.setSaldo(conta.getSaldo() + valor);
			} else {
				System.out.println("Valor a ser creditado precisa ser maior que zero.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conta;

	}

	public void transferencia(double valor, Conta contaOrigem, Conta contaDestino) {
		try {
			if (valor <= contaOrigem.getSaldo() && valor > 0) {
				contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
				contaDestino.setSaldo(contaDestino.getSaldo() + valor);
			} else if (valor <= 0) {
				System.out.println("Valor a ser transferido precisa ser maior que zero.");
			} else {
				System.out.println("A conta não possui saldo suficiente para realizar a transferência.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public abstract Conta debito(double valor, Conta conta);

}
