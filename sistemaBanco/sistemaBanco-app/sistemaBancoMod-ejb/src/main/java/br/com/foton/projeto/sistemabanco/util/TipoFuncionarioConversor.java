package br.com.foton.projeto.sistemabanco.util;

import javax.persistence.AttributeConverter;

import br.com.foton.projeto.sistemabanco.enums.TipoFuncionario;

public class TipoFuncionarioConversor implements AttributeConverter<TipoFuncionario, String> {

	@Override
	public String convertToDatabaseColumn(TipoFuncionario tipoFuncionario) {
		return tipoFuncionario.getValor();
	}

	@Override
	public TipoFuncionario convertToEntityAttribute(String valorTipoFuncionario) {
		return TipoFuncionario.valueOf(valorTipoFuncionario);
	}
}
