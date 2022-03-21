package br.com.pedro.defensoriapublica.beneficiario.web;

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
public class EnderecoResponseDto {

	private Long id;
	private Long cep;
	private String uf;
	private String cidade;
	private String logradouro;
	private String complemento;
	private Integer numero;

}
