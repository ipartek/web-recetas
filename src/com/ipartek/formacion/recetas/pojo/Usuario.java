package com.ipartek.formacion.recetas.pojo;

public class Usuario {

	private long id;
	private String nombre;
	private String email;
	private String imagen;
	private String gitUserName;
	private String password;
	
	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "anonimo";
		this.email = "admin@admin.com";
		this.imagen = "https://d304k3mn1nwj0a.cloudfront.net/the_simpsons/ralph.png";
	}
	
	public Usuario(String nombre) {
		super();
		this.nombre = nombre;
		this.imagen = "https://d304k3mn1nwj0a.cloudfront.net/the_simpsons/ralph.png";
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public String getGitUserName() {
		return gitUserName;
	}


	public void setGitUserName(String gitUserName) {
		this.gitUserName = gitUserName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", email=" + email + ", imagen=" + imagen + ", gitUserName="
				+ gitUserName + ", password=" + password + "]";
	}
	
	
}
