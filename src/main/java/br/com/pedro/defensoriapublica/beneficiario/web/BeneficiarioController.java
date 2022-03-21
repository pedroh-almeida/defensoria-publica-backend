package br.com.pedro.defensoriapublica.beneficiario.web;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.pedro.defensoriapublica.beneficiario.BeneficiarioService;
import br.com.pedro.defensoriapublica.beneficiario.models.entities.Beneficiario;
import br.com.pedro.defensoriapublica.beneficiario.models.entities.Contato;
import br.com.pedro.defensoriapublica.beneficiario.models.entities.Endereco;

@RestController
@RequestMapping("/v1/beneficiarios")
public class BeneficiarioController {


	private final BeneficiarioService service;
	
	public BeneficiarioController(BeneficiarioService service) {
		this.service = service;
	}
	
	@GetMapping("")
	public List<BeneficiarioResponseDto> buscarTodos() {
		return this.convertEntityToBeneficiarioResponseDto(this.service.buscarTodos());
	}
	
	@GetMapping("/{id}")
	public BeneficiarioResponseDto buscarPorId(@PathVariable Long id) {		
		return this.convertEntityToDto(this.service.buscarPorId(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Beneficiário com id " + id + " não encontrado.")));
	}
	
	@PostMapping
	public BeneficiarioResponseDto cadastrar(@RequestBody @Valid BeneficiarioRequestDto beneficiarioRequestDto) {
		return this.convertEntityToDto(this.service.cadastrar(this.convertDtoToEntity(beneficiarioRequestDto)));
	}
	
	@PutMapping("/{id}")
	public BeneficiarioResponseDto atualizar(@RequestBody BeneficiarioRequestDto beneficiario, @PathVariable Long id) {		
		return this.convertEntityToDto(this.service.atualizar(this.convertDtoToEntity(beneficiario)));
	}
	
	
	private BeneficiarioResponseDto convertEntityToDto(Beneficiario beneficiario) {
		return this.convertEntityToDtoBuild(beneficiario);
		
	}
	
	private Beneficiario convertDtoToEntity(BeneficiarioRequestDto beneficiario) {
		return this.convertDtoToEntityBuild(beneficiario);
	}
	
	private List<BeneficiarioResponseDto> convertEntityToBeneficiarioResponseDto(List<Beneficiario> beneficiarios) {
		List<BeneficiarioResponseDto> beneficiarioResponseDto = beneficiarios.stream().map(beneficiario -> BeneficiarioResponseDto
				.builder()
				.id(beneficiario.getId())
				.documento(beneficiario.getDocumento())
				.nome(beneficiario.getNome())
				.tipo(beneficiario.getTipo())
				.endereco(EnderecoResponseDto
						.builder()
						.id(beneficiario.getEndereco().getId())
						.cep(beneficiario.getEndereco().getCep())
						.uf(beneficiario.getEndereco().getUf())
						.cidade(beneficiario.getEndereco().getCidade())
						.logradouro(beneficiario.getEndereco().getLogradouro())
						.complemento(beneficiario.getEndereco().getComplemento())
						.numero(beneficiario.getEndereco().getNumero())
						.build())
				.contatos(beneficiario.getContatos().stream().map(contato -> ContatoResponseDto
						.builder()
						.id(contato.getId())
						.numero(contato.getNumero())
						.tipo(contato.getTipo())
						.build()).collect(Collectors.toList()))
				.build()).collect(Collectors.toList()); 
		
		
		
		return beneficiarioResponseDto;
	}
	
	private BeneficiarioResponseDto convertEntityToDtoBuild(Beneficiario beneficiario) {
		var b = BeneficiarioResponseDto
				.builder()
				.id(beneficiario.getId())
				.nome(beneficiario.getNome())
				.documento(beneficiario.getDocumento())
				.tipo(beneficiario.getTipo())
				.endereco(EnderecoResponseDto
						.builder()
						.id(beneficiario.getEndereco().getId())
						.cep(beneficiario.getEndereco().getCep())
						.uf(beneficiario.getEndereco().getUf())
						.cidade(beneficiario.getEndereco().getCidade())
						.logradouro(beneficiario.getEndereco().getLogradouro())
						.complemento(beneficiario.getEndereco().getComplemento())
						.numero(beneficiario.getEndereco().getNumero())
						.build())
				.contatos(beneficiario.getContatos().stream().map(contato -> ContatoResponseDto
						.builder()
						.id(contato.getId())
						.numero(contato.getNumero())
						.tipo(contato.getTipo())
						.build()).collect(Collectors.toList()))
				.build();
		
		return b;
	}

	private Beneficiario convertDtoToEntityBuild(BeneficiarioRequestDto beneficiario) {
		var b = Beneficiario
				.builder()
				.nome(beneficiario.getNome())
				.documento(beneficiario.getDocumento())
				.tipo(beneficiario.getTipo())
				.endereco(Endereco
						.builder()
						.cep(beneficiario.getEndereco().getCep())
						.uf(beneficiario.getEndereco().getUf())
						.cidade(beneficiario.getEndereco().getCidade())
						.logradouro(beneficiario.getEndereco().getLogradouro())
						.complemento(beneficiario.getEndereco().getComplemento())
						.numero(beneficiario.getEndereco().getNumero()).build())
				.contatos(beneficiario.getContatos().stream().map(contato -> Contato
						.builder()
						.numero(contato.getNumero())
						.tipo(contato.getTipo())
						.build()).collect(Collectors.toList()))
				.build();
		
		b.getContatos().forEach(c -> c.setBeneficiario(b));
		
		return b;
	}
	
}
























