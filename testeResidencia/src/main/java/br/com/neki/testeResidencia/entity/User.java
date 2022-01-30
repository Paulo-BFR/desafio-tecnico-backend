package br.com.neki.testeResidencia.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;



@Entity
@Table(name = "user", schema = "teste_residencia")
public class User {
			
	@Id
	@Column(name = "id", nullable = false)
	private Integer id;	
	
	@Column(name = "login", nullable = false,  length = 12)
	@Size(max = 12)
	private String login;
	
	
	@Column(name = "password", nullable = false,  length = 100)
	@Size(max = 100)
	private String password;
	
	@Column(name = "last_login_date")
	private Date lastLoginDate;
	
	public User(Integer id, String login, String password, Date lastLoginDate) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.lastLoginDate = lastLoginDate;
	}

	public User() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public Date getLastLoginDate() {
		return lastLoginDate;
	}



	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	
}
