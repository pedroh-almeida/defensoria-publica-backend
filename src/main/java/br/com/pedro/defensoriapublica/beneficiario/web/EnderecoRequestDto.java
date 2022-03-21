package br.com.pedro.defensoriapublica.beneficiario.web;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoRequestDto {
	
	@NotBlank(message = "É necessário informar o cep.")
	private Long cep;
	
	@NotBlank(message = "É necessário informar o UF")
	private String uf;

	@NotBlank(message = "É necessário informar a cidade.")
	private String cidade;

	@NotBlank(message = "É necessário informar o logradouro.")
	private String logradouro;

	private String complemento;
	
	@NotNull(message = "É necessário informar o número.")
	private Integer numero;
	
}
