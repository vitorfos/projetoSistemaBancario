package br.com.foton.projeto.sistemabanco.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import br.com.foton.projeto.sistemabanco.dao.ClienteContaDao;
import br.com.foton.projeto.sistemabanco.dao.ClienteDao;
import br.com.foton.projeto.sistemabanco.dao.ContaDao;
import br.com.foton.projeto.sistemabanco.dao.ContaSalarioDao;
import br.com.foton.projeto.sistemabanco.dao.EnderecoDao;
import br.com.foton.projeto.sistemabanco.dao.FuncionarioDao;
import br.com.foton.projeto.sistemabanco.dao.HistoricoTransacaoDao;
import br.com.foton.projeto.sistemabanco.dao.PessoaDao;
import br.com.foton.projeto.sistemabanco.entity.Cliente;
import br.com.foton.projeto.sistemabanco.entity.ClienteConta;
import br.com.foton.projeto.sistemabanco.entity.Conta;
import br.com.foton.projeto.sistemabanco.entity.ContaSalario;
import br.com.foton.projeto.sistemabanco.entity.Endereco;
import br.com.foton.projeto.sistemabanco.entity.Funcionario;
import br.com.foton.projeto.sistemabanco.entity.Pessoa;
import br.com.foton.projeto.sistemabanco.entity.Transacao;
import br.com.foton.projeto.sistemabanco.enums.TipoFuncionario;
import br.com.foton.projeto.sistemabanco.enums.TipoPessoa;
import br.com.foton.projeto.sistemabanco.enums.Titularidade;

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

	@Inject
	private HistoricoTransacaoDao daoTransacao;

	private ClienteContaDao daoClienteConta;

	@EJB
	private BeanContaSalario beanContaSal;

	@EJB
	private BeanContaPoupancaCorrente beanContaPoupCor;

	@PostConstruct
	public void novaTransacao() {
		// Teste de Transferencia
		Conta contaOrigem = (Conta) daoConta.retornarPorId(2);
		Conta contaDestino = (Conta) daoConta.retornarPorId(1);
		beanContaSal.transferencia(170, contaOrigem, contaDestino);
	}

	public Endereco inserirEndereco() {
		Endereco endereco = new Endereco();
		endereco.setCep(000000);
		endereco.setCidade("Cidade");
		endereco.setEstado("Estado");

		daoEndereco.salvar(endereco);
		return endereco;
	}

	public Pessoa inserirPessoa() {
		Pessoa pessoa = new Pessoa();
		pessoa.setTipoPessoa(TipoPessoa.F);
		pessoa.setCpf(000000);
		pessoa.setCnpj(00000);
		pessoa.setEndereco(inserirEndereco());

		daoPessoa.salvar(pessoa);
		return pessoa;
	}

	public Funcionario inserirFuncionario() {
		Funcionario funcionario = new Funcionario();
		funcionario.setSetor("");
		funcionario.setTipoFuncionario(TipoFuncionario.GER);
		funcionario.setPessoa(inserirPessoa());

		daoFuncionario.salvar(funcionario);
		return funcionario;
	}

	public Cliente inserirCliente() {
		Cliente cliente = new Cliente();
		cliente.setTitularidade(Titularidade.TIT);
		cliente.setPessoa(inserirPessoa());

		daoCliente.salvar(cliente);
		return cliente;
	}

	public Conta adicionarConta() {
		Conta conta = new Conta();
		conta.setAgencia(00000);
		conta.setNumero(000000);
		conta.setSaldo(00000);
		conta.setFuncionario(inserirFuncionario());

		daoConta.salvar(conta);
		adicionarClienteConta(inserirCliente(), conta);
		return conta;
	}

	public void adicionarClienteConta(Cliente cliente, Conta conta) {
		ClienteConta clienteConta = new ClienteConta();
		clienteConta.setCliente(inserirCliente());
		clienteConta.setConta(adicionarConta());

		daoClienteConta.salvar(clienteConta);
	}

}
