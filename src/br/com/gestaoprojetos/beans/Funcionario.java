package br.com.gestaoprojetos.beans;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Index;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name="FUNCIONARIO")
public class Funcionario implements Serializable{

	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer id;
	
	@NotNull(message="O Campo Nome é Obrigatório")
	@Column(name="NOME", length=150, nullable=false)
	@Index(name="IDX_FUNC_NOME")
	private String nome;
	
	@NotNull(message="O Campo CPF é Obrigatório")
	@CPF
	@Column(name="CPF", length=14, nullable=false, unique=true)
	private String cpf;
	
	@Email
	@Column(name="EMAIL", length=150, nullable=false)
	private String email;
	
	@Column(name="SALARIO", columnDefinition="numeric(10,2)")
	private Double salario;
	
	@Column(name="DATA_NASCIMENTO")
	private Calendar nascimento;
	
	@NotNull(message="O campo Ativo é Obrigatório")
	@Column(name="ATIVO", nullable=false)
	private Boolean ativo;
	
	@Column(name="FOTO")
	@Lob
	private Byte[] foto;
	
	@NotNull(message="O Campo Usuario é Obrigatório")
	@Column(name="USERNAME", length=20, nullable=false)
	@Index(name="IDX_FUNC_USERNAME")
	private String username;
	
	@NotNull(message="O Campo Usuario é Obrigatório")
	@Column(name="PASSWORD" , nullable=false)
	private String password;
	
	@NotNull(message="O Grupo deve ser Informado")
	@ManyToOne
	@JoinColumn(name="GRUPO_ID", referencedColumnName="ID", nullable=false)
	private Grupo grupo;
	
	@NotNull(message="O Setor deve ser Informado")
	@ManyToOne
	@JoinColumn(name="SETOR_ID", referencedColumnName="ID", nullable=false)
	private Setor setor;
	
	public Funcionario(){
		
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public Calendar getNascimento() {
		return nascimento;
	}
	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public Byte[] getFoto() {
		return foto;
	}
	public void setFoto(Byte[] foto) {
		this.foto = foto;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
		Funcionario other = (Funcionario) obj;
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

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	
	
	
}
