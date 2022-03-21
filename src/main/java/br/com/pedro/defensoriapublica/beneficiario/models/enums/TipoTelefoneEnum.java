package br.com.pedro.defensoriapublica.beneficiario.models.enums;

import lombok.Getter;

@Getter
public enum TipoTelefoneEnum {
	
	FIXO("F"), MOVEL("M");
	
	String tipo;

	
	TipoTelefoneEnum(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public static TipoTelefoneEnum from(String tipo) {
		
		switch (tipo) {
		case "F": {
			return FIXO;
		}
		case "M": {
			return MOVEL;
		}
		default:
			return null;
		}
	}
	
}
