package br.com.gestaoprojetos.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.gestaoprojetos.jpa.EntityManagerUtil;

public class GenericDAO {

	private EntityManager em;
	
	public GenericDAO(){
		em = EntityManagerUtil.getEntityManager();
	}
	
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
}
