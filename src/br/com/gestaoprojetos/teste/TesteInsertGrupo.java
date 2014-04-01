package br.com.gestaoprojetos.teste;

import javax.persistence.EntityManager;

import br.com.gestaoprojetos.beans.Grupo;
import br.com.gestaoprojetos.jpa.EntityManagerUtil;

public class TesteInsertGrupo {

	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		Grupo g = new Grupo();
		g.setNome("ADMINISTRADORES");
		em.getTransaction().begin();
		em.persist(g);
		em.getTransaction().commit();

	}

}
