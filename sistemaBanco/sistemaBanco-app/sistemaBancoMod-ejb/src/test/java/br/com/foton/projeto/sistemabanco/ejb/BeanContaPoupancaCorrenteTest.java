package br.com.foton.projeto.sistemabanco.ejb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.foton.projeto.sistemabanco.dao.ContaDao;
import br.com.foton.projeto.sistemabanco.dao.ContaPoupancaCorrenteDao;
import br.com.foton.projeto.sistemabanco.dao.HistoricoTransacaoDao;
import br.com.foton.projeto.sistemabanco.entity.Conta;
import br.com.foton.projeto.sistemabanco.entity.ContaPoupancaCorrente;

public class BeanContaPoupancaCorrenteTest
{
	
	ContaPoupancaCorrente contaPoupCor = new ContaPoupancaCorrente();
	
	@Mock
	private ContaPoupancaCorrenteDao daoContaPoupCor;
	
	@Mock
	private HistoricoTransacaoDao daoTransacao;
	
	@Mock 
	private ContaDao daoConta;
	
	@InjectMocks
	private BeanContaPoupancaCorrente beanContaPoupCor;
	
	@BeforeEach
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
	}
	
//Testes unitários para a operação de Credito --------------------------------------------------------------


	@Test
	public void testCreditoValorPositivo() {
		
		Conta conta = criaConta();
		Conta contaEsperada = criaConta();
		
		Mockito.when(daoContaPoupCor.salva(Mockito.any())).thenReturn(null);
		
		contaEsperada.setSaldo(contaEsperada.getSaldo() + (100 * 1.05));
		beanContaPoupCor.credito(100, conta);
		assertEquals(contaEsperada.getSaldo(), conta.getSaldo(), 0.0000001);

	}
	
	@Test
	public void testCreditoValorNegativo() {
		
		Conta conta = criaConta();
		Conta contaEsperada = criaConta();
		
		Mockito.when(daoContaPoupCor.salva(Mockito.any())).thenReturn(null);
		
		contaEsperada.setSaldo(contaEsperada.getSaldo() + ((-100) * 1.05));
		beanContaPoupCor.credito(-100, conta);
		assertNotEquals(contaEsperada.getSaldo(), conta.getSaldo(), 0.0000001);
		
	}
	
	@Test
	public void testCreditoContaInvalida() {
		
		Conta conta = new Conta();
		conta.setNumero(-123456);
		conta.setIdConta(1);
		conta.setSaldo(500);
		
		Conta contaEsperada = criaConta();
		
		Mockito.when(daoContaPoupCor.salva(Mockito.any())).thenReturn(null);
		
		contaEsperada.setSaldo(conta.getSaldo() + (100 * 1.05));
		beanContaPoupCor.credito(100, conta);
		assertNotEquals(contaEsperada.getSaldo(), conta.getSaldo(), 0.0000001);

	}

	
//Testes unitários para a operação de Debito ---------------------------------------------------------------
	
	@Test
	public void testDebitoValorPositivo() {
		
		Conta conta = criaConta();
		Conta contaEsperada = criaConta();
		
		Mockito.when(daoContaPoupCor.salva(Mockito.any())).thenReturn(null);
		
		contaEsperada.setSaldo(contaEsperada.getSaldo() - (100 * 1.005));
		beanContaPoupCor.debito(100, conta);
		
		assertEquals(contaEsperada.getSaldo(), conta.getSaldo(), 0.0000001);
	}
	
	@Test
	public void testDebitoValorNegativo() {
		
		Conta conta = criaConta();
		Conta contaEsperada = criaConta();

		Mockito.when(daoContaPoupCor.salva(Mockito.any())).thenReturn(null);
		
		contaEsperada.setSaldo(contaEsperada.getSaldo() + ((-100) * 1.005));
		beanContaPoupCor.debito((-100), conta);
		
		assertNotEquals(contaEsperada.getSaldo(), conta.getSaldo(), 0.000001);
	}
	
	@Test
	public void testDebitoSaldoIndisponivel() {
		
		Conta conta = criaConta();
		Conta contaEsperada = criaConta();
		
		Mockito.when(daoContaPoupCor.salva(Mockito.any())).thenReturn(null);
		
		contaEsperada.setSaldo(contaEsperada.getSaldo() - (600 * 1.005));
		beanContaPoupCor.debito(600, conta);
		
		assertNotEquals(contaEsperada.getSaldo(), conta.getSaldo(), 0.0000001);
	}
	
	@Test
	public void testDebitoContaInvalida() {
		
		Conta conta = new Conta();
		conta.setNumero(-123456);
		conta.setIdConta(1);
		conta.setSaldo(500);
		
		Conta contaEsperada = criaConta();
		
		Mockito.when(daoContaPoupCor.salva(Mockito.any())).thenReturn(null);
		
		contaEsperada.setSaldo(contaEsperada.getSaldo() - (100 * 1.005));
		beanContaPoupCor.debito(100, conta);
		
		assertNotEquals(contaEsperada.getSaldo(), conta.getSaldo(), 0.0000001);
	}

	
//Testes unitários para a operação de Transferencia --------------------------------------------------------------
	
	@Test
	public void testTransferenciaValorPositivo() {
		
		Conta contaOrigem = criaConta();
		
		Conta contaOrigemEsperada = criaConta();
		
		Conta contaDestino = criaConta();
		contaDestino.setAgencia(789456);
		contaDestino.setIdConta(2);
		contaDestino.setNumero(654321);
		contaDestino.setSaldo(500);
		
		Conta contaDestinoEsperada = criaConta();
		contaDestinoEsperada.setAgencia(789456);
		contaDestinoEsperada.setIdConta(2);
		contaDestinoEsperada.setNumero(654321);
		contaDestinoEsperada.setSaldo(500);
		
		Mockito.when(daoConta.salva(Mockito.any())).thenReturn(null);
		
		contaOrigemEsperada.setSaldo(contaOrigemEsperada.getSaldo() -  100);
		contaDestinoEsperada.setSaldo(contaDestinoEsperada.getSaldo() + 100);
		
		beanContaPoupCor.transferencia(100, contaOrigem, contaDestino);
		
		assertEquals(contaOrigemEsperada.getSaldo(), contaOrigem.getSaldo(), 0.0000001);
		assertEquals(contaDestinoEsperada.getSaldo(), contaDestino.getSaldo(), 0.0000001);
	}
	
	@Test
	public void testTransferenciaValorNegativo() {
		
		Conta contaOrigem = criaConta();
		
		Conta contaOrigemEsperada = criaConta();
		
		Conta contaDestino = criaConta();
		contaDestino.setAgencia(789456);
		contaDestino.setIdConta(2);
		contaDestino.setNumero(654321);
		contaDestino.setSaldo(1000);
		
		Conta contaDestinoEsperada = new Conta();
		contaDestinoEsperada.setAgencia(789456);
		contaDestinoEsperada.setIdConta(2);
		contaDestinoEsperada.setNumero(654321);
		contaDestinoEsperada.setSaldo(1000);
		
		Mockito.when(daoConta.salva(Mockito.any())).thenReturn(null);
		
		contaOrigemEsperada.setSaldo(contaOrigemEsperada.getSaldo() - (-100));
		contaDestinoEsperada.setSaldo(contaDestinoEsperada.getSaldo() + (-100));
		
		beanContaPoupCor.transferencia((-100), contaOrigem, contaDestino);
		
		assertNotEquals(contaOrigemEsperada.getSaldo(), contaOrigem.getSaldo(), 0.0000001);
		assertNotEquals(contaDestinoEsperada.getSaldo(), contaDestino.getSaldo(), 0.0000001);
		
	}
	
	@Test
	public void testTransferenciaSaldoIndisponivel() {
		
		Conta contaOrigem = criaConta();
		
		Conta contaOrigemEsperada = criaConta();
		
		Conta contaDestino = criaConta();
		contaDestino.setAgencia(789456);
		contaDestino.setIdConta(2);
		contaDestino.setNumero(654321);
		contaDestino.setSaldo(1000);
		
		Conta contaDestinoEsperada = new Conta();
		contaDestinoEsperada.setAgencia(789456);
		contaDestinoEsperada.setIdConta(2);
		contaDestinoEsperada.setNumero(654321);
		contaDestinoEsperada.setSaldo(1000);
		
		Mockito.when(daoConta.salva(Mockito.any())).thenReturn(null);
		
		contaOrigemEsperada.setSaldo(contaOrigemEsperada.getSaldo() -  700);
		contaDestinoEsperada.setSaldo(contaDestinoEsperada.getSaldo() + 700);
		
		beanContaPoupCor.transferencia(700, contaOrigem, contaDestino);
		
		assertNotEquals(contaOrigemEsperada.getSaldo(), contaOrigem.getSaldo(), 0.0000001);
		assertNotEquals(contaDestinoEsperada.getSaldo(), contaDestino.getSaldo(), 0.0000001);
	}
	
	@Test
	public void testTransferenciaMesmaConta() {
		
		Conta contaOrigem = criaConta();
		Conta contaOrigemEsperada = criaConta();
		
		Conta contaDestino = criaConta();
		Conta contaDestinoEsperada = criaConta();
		
		Mockito.when(daoConta.salva(Mockito.any())).thenReturn(null);
		
		contaOrigemEsperada.setSaldo(contaOrigemEsperada.getSaldo() -  100);
		contaDestinoEsperada.setSaldo(contaDestinoEsperada.getSaldo() + 100);
		
		beanContaPoupCor.transferencia(100, contaOrigem, contaDestino);
		
		assertNotEquals(contaOrigemEsperada.getSaldo(), contaOrigem.getSaldo(), 0.0000001);
		assertNotEquals(contaDestinoEsperada.getSaldo(), contaDestino.getSaldo(), 0.0000001);
	}
	
	@Test
	public void testTransferenciaContaInvalida() {
		
		Conta contaOrigem = criaConta();
		
		Conta contaOrigemEsperada = criaConta();
		
		Conta contaDestino = criaConta();
		contaDestino.setAgencia(789456);
		contaDestino.setIdConta(2);
		contaDestino.setNumero(-654321);
		contaDestino.setSaldo(1000);
		
		Conta contaDestinoEsperada = new Conta();
		contaOrigemEsperada.setAgencia(789456);
		contaOrigemEsperada.setIdConta(2);
		contaOrigemEsperada.setNumero(-654321);
		contaOrigemEsperada.setSaldo(1000);
		
		Mockito.when(daoContaPoupCor.salva(Mockito.any())).thenReturn(null);
		
		contaOrigemEsperada.setSaldo(contaOrigemEsperada.getSaldo() -  700);
		contaDestinoEsperada.setSaldo(contaDestinoEsperada.getSaldo() + 700);
		
		Mockito.when(daoConta.salva(Mockito.any())).thenReturn(null);
		
		assertNotEquals(contaOrigemEsperada.getSaldo(), contaOrigem.getSaldo(), 0.0000001);
		assertNotEquals(contaDestinoEsperada.getSaldo(), contaDestino.getSaldo(), 0.0000001);
	}

	private Conta criaConta() {
		
		Conta conta = new Conta();
		conta.setAgencia(12345);
		conta.setIdConta(1);
		conta.setNumero(123456);
		conta.setSaldo(500);
		
		return conta;
	}
	
}
