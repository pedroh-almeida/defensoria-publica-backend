package br.com.pedro.defensoriapublica.beneficiario.models.enums.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.pedro.defensoriapublica.beneficiario.models.enums.TipoTelefoneEnum;

@Converter(autoApply = true)
public class TipoTelefoneConverter implements AttributeConverter<TipoTelefoneEnum, String> {

	@Override
	public String convertToDatabaseColumn(TipoTelefoneEnum tipo) {
		return  tipo != null ? tipo.getTipo() : null;
	}

	@Override
	public TipoTelefoneEnum convertToEntityAttribute(String tipo) {
		return TipoTelefoneEnum.from(tipo);
	}

}
