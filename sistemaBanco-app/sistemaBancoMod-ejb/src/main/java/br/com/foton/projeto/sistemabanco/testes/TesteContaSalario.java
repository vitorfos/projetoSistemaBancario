package br.com.foton.projeto.sistemabanco.testes;

import br.com.foton.projeto.sistemabanco.dao.ContaSalarioDao;
import br.com.foton.projeto.sistemabanco.entity.ContaSalario;

public class TesteContaSalario {
	
	public static void main (String [] args) {
		ContaSalarioDao contaSalarioDao = new ContaSalarioDao();
		ContaSalario contaSalario = new ContaSalario();
		contaSalario.setTipoConta("poupanca");
		
		contaSalarioDao.salva(contaSalario);
	}

}
