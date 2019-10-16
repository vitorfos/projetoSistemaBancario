package br.com.foton.projeto.sistemabanco.dao;

import javax.persistence.Query;

import br.com.foton.projeto.sistemabanco.entity.ContaSalario;

public class ContaSalarioDao extends Dao<ContaSalario> {

	public ContaSalarioDao() {
		super(ContaSalario.class);
	}

//	public int retornaNumeroConta (ContaSalario contaS) {
//		Query consulta = getEntityManager().createQuery("select numero from (bdsistemabancario.ContaSalario inner join bdsistemabancario.Conta) where Conta.id_conta = ContaSalario.id_conta && id = " + contaS.getIdConta());		
//		int numeroConta = (int) consulta.getSingleResult();
//		return numeroConta;
//	}
}
