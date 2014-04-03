package br.com.gestaoprojetos.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.gestaoprojetos.beans.Grupo;
import br.com.gestaoprojetos.dao.GrupoDAO;

@ManagedBean(name="grupoController")
@SessionScoped
public class GrupoController implements Serializable {

	private GrupoDAO gDao;
	private Grupo objeto;

	public GrupoController() {
		gDao = new GrupoDAO();
	}
	

	public String novo(){
		return "form";
	}

	public String listar() {
		return "/admin/grupo/listar?faces-redirect=true";
	}
	
	public String cancelar(){
		return "listar";
	}

	public String salvar() {
		objeto = new Grupo();
		if (gDao.gravar(objeto)) {
			return "listar";
		} else {
			return "form";
		}
	}

	public String alterar(Grupo obj){
		
		objeto = obj;		
		return "form";		
	}
	
	public String deletar(Grupo obj){
		getgDao().remover(obj);
		return "listar";
	}

	public GrupoDAO getgDao() {
		return gDao;
	}

	public void setgDao(GrupoDAO gDao) {
		this.gDao = gDao;
	}

	public Grupo getObjeto() {
		return objeto;
	}

	public void setObjeto(Grupo objeto) {
		this.objeto = objeto;
	}

}
