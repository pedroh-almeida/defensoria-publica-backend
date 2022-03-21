package br.com.pedro.defensoriapublica.beneficiario.models.entities;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.pedro.defensoriapublica.beneficiario.models.enums.converters.TipoTelefoneConverter;
import br.com.pedro.defensoriapublica.beneficiario.models.enums.TipoTelefoneEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CONTATO")
public class Contato {
		
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CONTATO_ID")
    @SequenceGenerator(name = "SEQ_CONTATO_ID", sequenceName = "SEQ_CONTATO_ID", allocationSize = 1)
	private Long id;
	
	@Column(name = "NUMERO")
	private String numero;
	
	@Column(name = "TIPO")
	@Convert(converter = TipoTelefoneConverter.class)
	private TipoTelefoneEnum tipo;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ID_BENEFICIARIO", referencedColumnName = "ID")
	private Beneficiario beneficiario;

}
