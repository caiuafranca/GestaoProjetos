package br.com.gestaoprojetos.dao;

import java.security.PublicKey;
import java.util.List;

import br.com.gestaoprojetos.beans.Grupo;
import br.com.gestaoprojetos.util.UtilErros;
import br.com.gestaoprojetos.util.UtilMensagens;

public class GrupoDAO  extends GenericDAO{

	public GrupoDAO(){
		
	}
	
	public List<Grupo> listarTodos(){
		return getEm().createQuery("from Grupo order by nome").getResultList();
	}
	
	public Boolean gravar(Grupo obj){
					
		try {
			getEm().getTransaction().begin();
			
			if(obj.getId() == null){
				getEm().persist(obj);
			}else{
				getEm().merge(obj);
			}
			getEm().getTransaction().commit();
			UtilMensagens.mensagemInformacao("Dado Inserido com Sucesso!");
			return true;
			
		} catch (Exception e) {
			
			if(getEm().getTransaction().isActive() == false){
				getEm().getTransaction().begin();
			}
			getEm().getTransaction().rollback();
			UtilMensagens.mensagemError("Não foi Possivel Gravar a Informação: " +
					UtilErros.getMessageError(e));
			return false;
		}
		
	}
	
	public Boolean remover(Grupo obj){
		
		try {
			getEm().getTransaction().begin();
			getEm().remove(obj);
			getEm().getTransaction().commit();
			UtilMensagens.mensagemInformacao("Dado Removido com Sucesso!");
			return true;
			
		} catch (Exception e) {
			
			if(getEm().getTransaction().isActive() == false){
				getEm().getTransaction().begin();
			}
			getEm().getTransaction().rollback();
			UtilMensagens.mensagemError("Não foi Possivel Remover a Informação: " +
					UtilErros.getMessageError(e));
			return false;
		}
		
	}

	public Grupo buscar(Integer id){
		return getEm().find(Grupo.class, id);
	}

}
