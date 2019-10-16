package br.com.foton.projeto.sistemabanco.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.foton.projeto.sistemabanco.enums.Titularidade;
import br.com.foton.projeto.sistemabanco.util.TitularidadeConversor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Cliente extends Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8006215540980746248L;

	@Id
	@Column(name = "id_cliente")
	private int idCliente;

	@Convert(converter = TitularidadeConversor.class)
	@Column(name = "titularidade")
	private Titularidade titularidade;

	// Cliente tem a FK de Pessoa
	@Column(name = "id_pessoa")
	private int idPessoa;

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa", foreignKey = @ForeignKey(name = "id_pessoaFK1"), insertable = false, updatable = false)
	private Pessoa pessoa;
}
