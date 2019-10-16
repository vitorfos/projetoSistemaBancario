package br.com.foton.projeto.sistemabanco.ejb;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.foton.projeto.sistemabanco.dao.ContaDao;
import br.com.foton.projeto.sistemabanco.dao.HistoricoTransacaoDao;
import br.com.foton.projeto.sistemabanco.entity.Conta;
import br.com.foton.projeto.sistemabanco.enums.TipoOperacao;

public abstract class BeanConta implements Serializable {

	private static final long serialVersionUID = -1242388914027391591L;

	@Inject
	private ContaDao daoConta;

	@Inject
	private HistoricoTransacaoDao daoHistoricoTransacao;

	public Conta credito(double valor, Conta conta) {
		try {
			if (valor > 0 && conta.getNumero() != 0) {
				conta.setSaldo(conta.getSaldo() + valor);
				daoConta.salvar(conta);

				TipoOperacao tipoOperacao = TipoOperacao.CRED;
				try {
					daoHistoricoTransacao.gravarHistorico(conta, conta, valor, tipoOperacao);
				} catch (Exception e) {
					e.printStackTrace();
				}
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
			if (valor <= contaOrigem.getSaldo() && valor > 0 && contaOrigem.getNumero() != contaDestino.getNumero()) {
				contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
				contaDestino.setSaldo(contaDestino.getSaldo() + valor);
				daoConta.salvar(contaOrigem);
				daoConta.salvar(contaDestino);

				TipoOperacao tipoOperacao = TipoOperacao.TRANSF;
				try {
					daoHistoricoTransacao.gravarHistorico(contaOrigem, contaDestino, valor, tipoOperacao);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (valor <= 0) {
				System.out.println("Valor a ser transferido precisa ser maior que zero.");
			} else if (contaOrigem.getNumero() != contaDestino.getNumero()) {
				System.out.println("A operação de transferência deve ser realizada entre contas diferentes.");
			} else {
				System.out.println("A conta não possui saldo suficiente para realizar a transferência.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public abstract Conta debito(double valor, Conta conta);

}
