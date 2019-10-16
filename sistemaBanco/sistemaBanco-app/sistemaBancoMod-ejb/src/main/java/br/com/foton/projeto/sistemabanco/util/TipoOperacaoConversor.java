package br.com.foton.projeto.sistemabanco.util;

import javax.persistence.AttributeConverter;

import br.com.foton.projeto.sistemabanco.enums.TipoOperacao;

public class TipoOperacaoConversor implements AttributeConverter<TipoOperacao, String> {

	@Override
	public String convertToDatabaseColumn(TipoOperacao tipoOperacao) {
		return tipoOperacao.getValor();
	}

	@Override
	public TipoOperacao convertToEntityAttribute(String valorTipoOperacao) {
		return TipoOperacao.valueOf(valorTipoOperacao);
	}
}