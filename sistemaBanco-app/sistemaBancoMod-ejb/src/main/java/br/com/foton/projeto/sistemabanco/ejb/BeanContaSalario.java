package br.com.foton.projeto.sistemabanco.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.foton.projeto.sistemabanco.constantes.Constante;
import br.com.foton.projeto.sistemabanco.dao.ContaSalarioDao;
import br.com.foton.projeto.sistemabanco.dao.HistoricoTransacaoDao;
import br.com.foton.projeto.sistemabanco.entity.Conta;
import br.com.foton.projeto.sistemabanco.enums.TipoOperacao;

@Stateless
public class BeanContaSalario extends BeanConta {

	private static final long serialVersionUID = -5428061635036848588L;

	@Inject
	private ContaSalarioDao daoContaSal;

	@Inject
	private HistoricoTransacaoDao daoHistoricoTransacao;

	@Override
	public Conta debito(double valor, Conta conta) {
		try {
			if (conta.getSaldo() > valor && valor > 0) {
				conta.setSaldo((conta.getSaldo() - (valor * Constante.TX_OP_DEBITO_CONTA_SALARIO)));
				daoContaSal.salvar(conta);

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

}
