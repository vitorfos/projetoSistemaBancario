package br.com.foton.projeto.sistemabanco.util;

import javax.persistence.AttributeConverter;

import br.com.foton.projeto.sistemabanco.enums.Titularidade;

public class TitularidadeConversor implements AttributeConverter<Titularidade, String> {

	@Override
	public String convertToDatabaseColumn(Titularidade titularidade) {
		return titularidade.getValor();
	}

	@Override
	public Titularidade convertToEntityAttribute(String valorTitularidade) {
		return Titularidade.valueOf(valorTitularidade);
	}
}
