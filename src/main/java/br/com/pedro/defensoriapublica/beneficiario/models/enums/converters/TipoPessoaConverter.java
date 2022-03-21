package br.com.pedro.defensoriapublica.beneficiario.models.enums.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.pedro.defensoriapublica.beneficiario.models.enums.TipoPessoaEnum;

@Converter(autoApply = true)
public class TipoPessoaConverter implements AttributeConverter<TipoPessoaEnum, String>{

	@Override
	public String convertToDatabaseColumn(TipoPessoaEnum tipo) {
		return tipo != null ? tipo.getTipo() : null;
	}

	@Override
	public TipoPessoaEnum convertToEntityAttribute(String tipo) {
		return TipoPessoaEnum.from(tipo);
	}

}
