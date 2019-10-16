package br.com.foton.projeto.sistemabanco.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.foton.projeto.sistemabanco.enums.TipoFuncionario;
import br.com.foton.projeto.sistemabanco.util.TipoFuncionarioConversor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Funcionario extends Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2131431787114488991L;

	@Id
	@Column(name = "id_funcionario")
	private int idFuncionario;
	@Column
	private String setor;
	@Convert(converter = TipoFuncionarioConversor.class)
	@Column(name = "tipo_funcionario")
	private TipoFuncionario tipoFuncionario;

	// Funcionario tem a FK de Pessoa
	@Column(name = "id_pessoa")
	private int idPessoa;

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa", foreignKey = @ForeignKey(name = "id_pessoaFK"), insertable = false, updatable = false)
	private Pessoa pessoa;

}
