package br.com.foton.projeto.sistemabanco.util;

import javax.persistence.AttributeConverter;

import br.com.foton.projeto.sistemabanco.enums.TipoPessoa;

public class TipoPessoaConversor implements AttributeConverter<TipoPessoa, String> {

	@Override
	public String convertToDatabaseColumn(TipoPessoa tipoPessoa) {
		return tipoPessoa.getValor();
	}

	@Override
	public TipoPessoa convertToEntityAttribute(String valorTipoPessoa) {
		return TipoPessoa.valueOf(valorTipoPessoa);
	}

}
