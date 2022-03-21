package br.com.pedro.defensoriapublica.beneficiario.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
@Table(name = "ENDERECO")
public class Endereco {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ENDERECO_ID")
    @SequenceGenerator(name = "SEQ_ENDERECO_ID", sequenceName = "SEQ_ENDERECO_ID", allocationSize = 1)
	private Long id;
	
	@Column(name = "CEP")
	private Long cep;
	
	@Column(name = "UF")
	private String uf;
	
	@Column(name = "CIDADE")
	private String cidade;
	
	@Column(name = "LOGRADOURO")
	private String logradouro;
	
	@Column(name = "COMPLEMENTO")
	private String complemento;
	
	@Column(name = "NUMERO")
	private Integer numero;

}
