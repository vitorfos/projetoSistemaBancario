package br.com.foton.projeto.sistemabanco.util;

import javax.persistence.AttributeConverter;

import br.com.foton.projeto.sistemabanco.enums.BloqueioConta;

public class BloqueioContaConversor implements AttributeConverter<BloqueioConta, String> {

	@Override
	public String convertToDatabaseColumn(BloqueioConta bloqueioConta) {
		return bloqueioConta.getValor();
	}

	@Override
	public BloqueioConta convertToEntityAttribute(String valorBloqueioConta) {
		return BloqueioConta.valueOf(valorBloqueioConta);
	}

}
