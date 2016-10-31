package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Model of system's user.
 * @author JanioXavier
 *
 */
@Entity
@Table(name="account")
public class User {
	@Column(name="name", nullable=false)
	private String nome;
	
	@Id
	@Column(name="login", nullable=false)
	private String login;
	
	@Column(name="password", nullable=false)
	private String senha;
	
	@Column(name="age", nullable=false)
	private int idade;
	
	@Column(name="role",nullable=false)
	private String role;

	
	public User() {
		
	}
	
	public User(String nome, int idade, String login, String senha, String role) {
		this.nome = nome;
		this.idade= idade;
		this.login = login;
		this.senha = senha;
		this.role = role;
	}
		
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "User [nome=" + nome + ", idade=" + idade + ", login=" + login + ", senha=" + senha + ", role=" + role
				+ "]";
	}
	
	
}
