package com.example.demoReplay.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
public class User {
	@Id
	@GeneratedValue( strategy=GenerationType.AUTO )
	private Long id;
	
	@Valid
	@Size( min=1, max=32, message="Name must be between 1-32 characters!" )
	private String name;

	@Email( message="Invalid Email Format. Example: example@example.com")
	@Size( min = 1, message="Invalid Email Format. Example: example@example.com" )
	private String email;
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@OneToMany( fetch=FetchType.LAZY, mappedBy="user" )
	private List<Post> posts;

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

	@Size(min=1,max=32,message="Password must be between 1-32 characters.")
	private String password;
	
	@Size(min=1,max=32,message="Password Confirmation must be between 1-32 characters.")
	@Transient
	private String confirm;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}