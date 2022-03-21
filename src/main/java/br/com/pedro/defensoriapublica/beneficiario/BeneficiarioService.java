package br.com.pedro.defensoriapublica.beneficiario;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.pedro.defensoriapublica.beneficiario.models.entities.Beneficiario;

@Service
public class BeneficiarioService {
	
	private final BeneficiarioRepository repository;
	
	public BeneficiarioService(BeneficiarioRepository repository) {
		this.repository = repository;
	}
	
	public List<Beneficiario> buscarTodos() {
		return this.repository.findAll();
	}

	public Optional<Beneficiario> buscarPorId(Long id) {
		return this.repository.findById(id);
	}

	public Beneficiario cadastrar(Beneficiario beneficiario) {
		return this.repository.save(beneficiario);
	}

	public Beneficiario atualizar(Beneficiario beneficiario) {
		return this.repository.save(beneficiario);
	}
	
}
