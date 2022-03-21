package br.com.pedro.defensoriapublica.beneficiario.web;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.pedro.defensoriapublica.beneficiario.models.enums.TipoPessoaEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BeneficiarioRequestDto {
	
	@NotBlank(message = "É necessário informar o nome.")
	private String nome;

	@NotBlank(message = "É necessário informar o documento.")
	private String documento;

	@NotNull(message = "É necessário informar se é pessoa jurídica ou física.")
	private TipoPessoaEnum tipo;

	@NotNull(message = "É necessário informar o endereço.")
	private EnderecoRequestDto endereco;

	@NotNull(message = "É necessário informar um contato.")
	@Size(min = 1, message = "É necessário informar ao menos um telefone para contato.")
	private List<ContatoRequestDto> contatos;

}
