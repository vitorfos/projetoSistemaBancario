package br.com.foton.projeto.sistemabanco.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.foton.projeto.sistemabanco.entity.Entidade;

public abstract class Dao<T extends Entidade> {

	@PersistenceContext(unitName = "sistemaBanco")
	private EntityManager em;

	private Class<T> classeEntidade;

	public Dao(Class<T> classeEntidade) {
		this.classeEntidade = classeEntidade;
	}

	public EntityManager getEntityManager() {
		return em;
	}

	public void atualiza(Entidade entidade) {
		this.salva(entidade);
	}

	public Entidade salva(Entidade entidade) {

		return em.merge(entidade);

	}

	public void remove(int id) {

		Query remover = getEntityManager().createQuery("delete from " + classeEntidade.getName() + " where id = " + id);
		remover.executeUpdate();

	}

	public List<T> retornaTodos() {

		Query consulta = getEntityManager().createQuery("select c from " + classeEntidade.getName() + " c",
				classeEntidade);
		List<T> resultados = consulta.getResultList();
		System.out.println(resultados);
		return resultados;

	}
	
	public Entidade retornaPorId(int id) {

		Query consulta = getEntityManager().createQuery("from "+classeEntidade.getSimpleName()+" where id_"+classeEntidade.getSimpleName().substring(0,1).toLowerCase().concat(classeEntidade.getSimpleName().substring(1))+" = " +id,
				classeEntidade);
		return (Entidade) consulta.getSingleResult();

	}


}
