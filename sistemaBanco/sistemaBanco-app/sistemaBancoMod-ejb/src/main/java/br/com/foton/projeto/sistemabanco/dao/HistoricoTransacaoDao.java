package br.com.foton.projeto.sistemabanco.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.foton.projeto.sistemabanco.entity.Conta;
import br.com.foton.projeto.sistemabanco.entity.ContaSalario;
import br.com.foton.projeto.sistemabanco.entity.Transacao;

@SuppressWarnings("unused")
public class HistoricoTransacaoDao extends Dao<Transacao>{
	
	private EntityManager em;

	public HistoricoTransacaoDao() {
		super(Transacao.class);
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
