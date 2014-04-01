package br.com.gestaoprojetos.teste;


import javax.persistence.EntityManager;
import br.com.gestaoprojetos.beans.Setor;
import br.com.gestaoprojetos.jpa.EntityManagerUtil;

public class TesteInsertSetor {

	public static void main(String[] args) {
	
		EntityManager em = EntityManagerUtil.getEntityManager();
		Setor s = new Setor();
		s.setNome("ADMINISTRACAO");
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		
	}

}
