package br.com.foton.projeto.sistemabanco.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import br.com.foton.projeto.sistemabanco.dao.ClienteDao;
import br.com.foton.projeto.sistemabanco.dao.ContaDao;
import br.com.foton.projeto.sistemabanco.dao.ContaSalarioDao;
import br.com.foton.projeto.sistemabanco.dao.EnderecoDao;
import br.com.foton.projeto.sistemabanco.dao.FuncionarioDao;
import br.com.foton.projeto.sistemabanco.dao.PessoaDao;
import br.com.foton.projeto.sistemabanco.entity.Conta;
import br.com.foton.projeto.sistemabanco.entity.ContaSalario;

@Startup
@Singleton
@SuppressWarnings("unused")
public class Teste {


	@Inject
	private EnderecoDao daoEndereco;

	@Inject
	private FuncionarioDao daoFuncionario;

	@Inject
	private PessoaDao daoPessoa;
	
	@Inject
	private ClienteDao daoCliente;
	
	@Inject
	private ContaDao daoConta;
	
	@Inject
	private ContaSalarioDao daoCs;
	
	
	@EJB
	private BeanContaSalario beanConta;
	
	
	@PostConstruct
	public void novaTransacao () {
//			Conta conta = new Conta();
			Conta contaOrigem = (Conta) daoConta.retornaPorId(4);
			Conta contaDestino = (Conta) daoConta.retornaPorId(3);
//			beanConta.transferencia(500, contaOrigem, contaDestino);
//	      	daoConta.retornaTodos();
			
			
		//retornaPorId funciona apenas para a entidade Conta
//		ContaSalario conta = (ContaSalario) daoCs.retornaPorId(1);
//		daoCs.retornaNumeroConta(conta);
//		System.out.println(daoCs.retornaNumeroConta(conta));
	}


}
