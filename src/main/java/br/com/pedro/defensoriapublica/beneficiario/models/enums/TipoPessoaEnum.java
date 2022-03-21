package br.com.pedro.defensoriapublica.beneficiario.models.enums;

import lombok.Getter;

@Getter
public enum TipoPessoaEnum {
	
	PJ("J", "PESSOA JURIDICA"), PF("F", "PESSOA FISICA");
	
	String tipo;
	String descricao;
	
	TipoPessoaEnum(String tipo, String descricao) {
		this.tipo = tipo;
		this.descricao = descricao;
	}
	
	public static TipoPessoaEnum from(String tipo) {
		
		switch (tipo) {
		case "J": {
			return PJ;
		}
		case "F": {
			return PF;
		}
		default:
			return null;
		}
	}

	public String getTipo() {
		return tipo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	

}
