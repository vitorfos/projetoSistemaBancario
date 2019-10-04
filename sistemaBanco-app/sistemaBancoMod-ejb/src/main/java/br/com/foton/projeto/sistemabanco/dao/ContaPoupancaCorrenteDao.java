package br.com.foton.projeto.sistemabanco.dao;

import javax.persistence.Query;

import br.com.foton.projeto.sistemabanco.entity.ContaPoupancaCorrente;
import br.com.foton.projeto.sistemabanco.entity.ContaSalario;

public class ContaPoupancaCorrenteDao extends Dao<ContaPoupancaCorrente> {

	public ContaPoupancaCorrenteDao() {
		super(ContaPoupancaCorrente.class);
	}
	
	public int retornaNumeroConta (ContaPoupancaCorrente contaPoupCor) {
		Query consulta = getEntityManager().createQuery("select numero from (bdsistemabancario.ContaPoupancaCorrente inner join bdsistemabancario.Conta) where Conta.id_conta = ContaPoupancaCorrente.id_conta && id = " + contaPoupCor.getIdConta());		
		int numeroConta = (int) consulta.getSingleResult();
		return numeroConta;
	}

}
