package br.com.foton.projeto.sistemabanco.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.foton.projeto.sistemabanco.constantes.Constante;
import br.com.foton.projeto.sistemabanco.dao.ContaPoupancaCorrenteDao;
import br.com.foton.projeto.sistemabanco.dao.HistoricoTransacaoDao;
import br.com.foton.projeto.sistemabanco.entity.Conta;
import br.com.foton.projeto.sistemabanco.enums.TipoOperacao;
import br.com.foton.projeto.sistemabanco.negocio.OperacaoServico;

@Stateless
public class BeanContaPoupancaCorrente extends BeanConta {

	private static final long serialVersionUID = -4304726078724448172L;

	@Inject
	private ContaPoupancaCorrenteDao daoContaPoupCor;

	@Inject
	private HistoricoTransacaoDao daoHistoricoTransacao;

	@Override
	public Conta debito(double valor, Conta conta) {
		try {
			if (valor < conta.getSaldo() && valor > 0 && conta.getNumero() != 0) {
				conta.setSaldo((conta.getSaldo() - (valor * Constante.TX_OP_DEBITO_CONTA_POUP_CORRENTE)));
				daoContaPoupCor.salvar(conta);

				TipoOperacao tipoOperacao = TipoOperacao.DEB;
				try {
					daoHistoricoTransacao.gravarHistorico(conta, conta, valor, tipoOperacao);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (valor < 0) {
				System.out.println("DEBITO - Insira um valor maior que zero para ser debitado.");
			} else {
				System.out.println("DEBITO - A conta não possui saldo suficiente para realizar a transferência.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conta;
	}

	@Override
	public Conta credito(double valor, Conta conta) {
		try {
			if (valor > Constante.ZERO && conta.getNumero() > 0) {
				double bonificacaoVariavelCredito = OperacaoServico.bonificacaoVariavelCredito(valor);
				super.credito(bonificacaoVariavelCredito, conta);
				daoContaPoupCor.salvar(conta);

				TipoOperacao tipoOperacao = TipoOperacao.CRED;
				try {
					daoHistoricoTransacao.gravarHistorico(conta, conta, valor, tipoOperacao);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("CREDITO - Insira um valor maior que Zero para ser creditado.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conta;
	}

}
