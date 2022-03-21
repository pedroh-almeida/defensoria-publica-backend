package br.com.pedro.defensoriapublica.beneficiario.models.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.pedro.defensoriapublica.beneficiario.models.enums.TipoPessoaEnum;
import br.com.pedro.defensoriapublica.beneficiario.models.enums.converters.TipoPessoaConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BENEFICIARIO")
public class Beneficiario {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BENEFICIARIO_ID")
    @SequenceGenerator(name = "SEQ_BENEFICIARIO_ID", sequenceName = "SEQ_BENEFICIARIO_ID", allocationSize = 1)
	private Long id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "DOCUMENTO")
	private String documento;
	
	@Convert(converter = TipoPessoaConverter.class)
	@Column(name = "TIPO_PESSOA")
	private TipoPessoaEnum tipo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_ENDERECO", referencedColumnName = "ID")
	private Endereco endereco;
	
	@OneToMany(mappedBy = "beneficiario", cascade = CascadeType.ALL)
	private List<Contato> contatos;

}
