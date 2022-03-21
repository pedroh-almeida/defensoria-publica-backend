package br.com.pedro.defensoriapublica.beneficiario.web;

import br.com.pedro.defensoriapublica.beneficiario.models.enums.TipoTelefoneEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContatoResponseDto {
	
	
	private Long id;
	private String numero;
	private TipoTelefoneEnum tipo;
	
	
}
