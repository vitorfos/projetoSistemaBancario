package br.com.foton.projeto.sistemabanco.util;

import javax.persistence.AttributeConverter;

import br.com.foton.projeto.sistemabanco.enums.TipoConta;

public class TipoContaConversor implements AttributeConverter<TipoConta, String> {

	@Override
	public String convertToDatabaseColumn(TipoConta tipoConta) {
		return tipoConta.getValor();
	}

	@Override
	public TipoConta convertToEntityAttribute(String valorTipoConta) {
		return TipoConta.valueOf(valorTipoConta);
	}
}
