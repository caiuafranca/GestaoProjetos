package br.com.gestaoprojetos.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.gestaoprojetos.beans.Funcionario;
import br.com.gestaoprojetos.beans.Grupo;
import br.com.gestaoprojetos.beans.Setor;
import br.com.gestaoprojetos.jpa.EntityManagerUtil;

public class TesteInserirFuncionario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = EntityManagerUtil.getEntityManager();
		Grupo g = em.find(Grupo.class, 1);
		Setor s = em.find(Setor.class, 1);
		
		Funcionario f = new Funcionario();
		
		f.setNome("Caiua");
		f.setAtivo(true);
		f.setCpf("01223793494");
		f.setEmail("caiua_franca@hotmail.com");
		f.setGrupo(g);
		f.setNascimento(Calendar.getInstance());
		f.setSalario(3000.00);
		f.setSetor(s);
		f.setUsername("caiua.franca");
		f.setPassword("123456");
		em.getTransaction().begin();
		em.persist(f);
		em.getTransaction().commit();
		

	}

}
