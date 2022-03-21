package br.com.pedro.defensoriapublica.beneficiario.web;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.pedro.defensoriapublica.beneficiario.models.enums.TipoTelefoneEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContatoRequestDto {
	
	private Long id;
	
	@NotBlank(message = "É necessário informar o numero do telefone.")
	private String numero;
	
	@NotNull(message = "É necessário informar o tipo do telefone.")
	private TipoTelefoneEnum tipo;

}
