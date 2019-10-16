package br.com.foton.projeto.sistemabanco.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.foton.projeto.sistemabanco.enums.TipoPessoa;
import br.com.foton.projeto.sistemabanco.util.TipoPessoaConversor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Pessoa extends Entidade {

	private static final long serialVersionUID = -7673541242396005106L;

	@Id
	@Column(name = "id_pessoa")
	private int idPessoa;
	@Column
	private String nome;
	@Convert(converter = TipoPessoaConversor.class)
	@Column(name = "tipo_pessoa")
	private TipoPessoa tipoPessoa;
	@Column
	private int rg;
	@Column
	private int cpf;
	@Column
	private int cnpj;

	// Pessoa tem a FK de Endereco
	@Column(name = "id_endereco")
	private int idEndereco;

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco", foreignKey = @ForeignKey(name = "id_enderecoFK"), insertable = false, updatable = false)
	private Endereco endereco;

}
