package com.purchaseapp.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="TAB_USER")
public class User implements Serializable {
	/**
	 * UID
	 */
	private static final long serialVersionUID = 6305155517049047087L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="NAME", length=100, nullable=false)
	private String username;
	
	@Column(name="EMAIL", length=100, nullable=false, unique=true)
	private String email;
	
	@Column(name="PASSWORD", length=100, nullable=false)
	private String password;
	
	@Transient
	private String confirm;
	
	private boolean active = Boolean.FALSE;
	
	
	
	public User() {}

	public User(Integer id, String username, String email, String password, String confirm, boolean active) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.confirm = confirm;
		this.active = active;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", confirm=" + confirm + ", active=" + active + "]";
	}
}
