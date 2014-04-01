package br.com.gestaoprojetos.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.gestaoprojetos.beans.Funcionario;
import br.com.gestaoprojetos.beans.Projeto;
import br.com.gestaoprojetos.beans.ProjetoFuncionario;
import br.com.gestaoprojetos.beans.Setor;
import br.com.gestaoprojetos.jpa.EntityManagerUtil;

public class TesteInderirProjetos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = EntityManagerUtil.getEntityManager();
		Setor s = em.find(Setor.class, 1);
		Funcionario f = em.find(Funcionario.class, 1);
		Projeto p = new Projeto();
		p.setAtivo(true);
		p.setDescricao("Projeto de Sistema de Ouvidoria");
		p.setNome("UniOuve");
		p.setInicio(Calendar.getInstance());
		p.setFim(Calendar.getInstance());
		p.setSetor(s);
		
		ProjetoFuncionario pj = new ProjetoFuncionario();
		pj.setFuncionario(f);
		pj.setCargaHoraria(200);
		pj.setInicioParticipacao(Calendar.getInstance());
		pj.setGestor(true);
		pj.setFimParticipacao(Calendar.getInstance());
		p.addFuncionario(pj);
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		
	}

}
