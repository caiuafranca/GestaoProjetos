package br.com.gestaoprojetos.beans;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="PROJETO")
public class Projeto implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer id;
	
	@NotNull(message="O nome do Projeto é Obrigatório")
	@Column(name="NOME", nullable=false)
	private String nome;
	
	@NotNull(message="A Descricao do projeto é Obrigatório")
	@Lob
	@Column(name="DESCRICAO", nullable=false)
	private String descricao;
	
	@Column(name="INICIO")
	private Calendar inicio;
	
	@Column(name="FIM")
	private Calendar fim;
	
	@Column(name="ATIVO")
	private Boolean ativo;
	
	@NotNull(message="O Setor deve ser Informado")
	@ManyToOne
	@JoinColumn(name="SETOR_ID", referencedColumnName="ID", nullable=false)
	private Setor setor;
	
	@OneToMany(mappedBy="projeto", cascade={CascadeType.ALL}, orphanRemoval=true)
	@LazyCollection(LazyCollectionOption.EXTRA)
	@OrderBy(value="id asc")
	private List<ProjetoFuncionario> funcionarios = 
									 new ArrayList<ProjetoFuncionario>();
	
	public Projeto(){
		
	}
	
	public void addFuncionario(ProjetoFuncionario obj){
			obj.setProjeto(this);
			this.funcionarios.add(obj);
	}
	
	public void delFuncionario(ProjetoFuncionario obj){
		if(this.funcionarios.contains(obj)){
			this.funcionarios.remove(obj);
		}
	}
	
	public void delTodosFuncionarios(){
		
		this.funcionarios.clear();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Calendar getInicio() {
		return inicio;
	}
	public void setInicio(Calendar inicio) {
		this.inicio = inicio;
	}
	public Calendar getFim() {
		return fim;
	}
	public void setFim(Calendar fim) {
		this.fim = fim;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public Setor getSetor() {
		return setor;
	}
	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projeto other = (Projeto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nome;
	}

	public List<ProjetoFuncionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<ProjetoFuncionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	
	
	

}
