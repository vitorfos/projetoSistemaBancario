package br.com.foton.projeto.sistemabanco.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.foton.projeto.sistemabanco.entity.Conta;
import br.com.foton.projeto.sistemabanco.entity.ContaSalario;
import br.com.foton.projeto.sistemabanco.entity.Transacao;
import br.com.foton.projeto.sistemabanco.enums.TipoOperacao;

@SuppressWarnings("unused")
public class HistoricoTransacaoDao extends Dao<Transacao>{
	
	private EntityManager em;

	public HistoricoTransacaoDao() {
		super(Transacao.class);
	}
	
	@Inject
	private Transacao transacao;

	public Boolean gravaHistorico(Conta contaOrigem, Conta contaDestino, double valor, TipoOperacao tipoOperacao) {
	
		try {
			
			transacao.setNumeroContaOrigem(contaOrigem.getNumero());
			transacao.setIdContaOrigem(contaOrigem.getIdConta());
			transacao.setIdContaDestino(contaDestino.getIdConta());
			transacao.setTipoOperacao(tipoOperacao);
			transacao.setNumeroContaDestino(contaDestino.getNumero());
			transacao.setValorTransacao(valor);
		
			salva(transacao);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}


//public int retornaNumeroConta (ContaSalario contaS) {
//	Query consulta = getEntityManager().createQuery("select numero from (bdsistemabancario.ContaSalario inner join bdsistemabancario.Conta) where Conta.id_conta = ContaSalario.id_conta && id = " + contaS.getIdConta());		
//	int numeroConta = (int) consulta.getSingleResult();
//	return numeroConta;
//}
//public void registraTransacao (Conta contaOrigem, Conta contaDestino, double valor) {
//	em.merge(null);
//}
