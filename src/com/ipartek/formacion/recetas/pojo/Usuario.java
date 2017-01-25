package com.ipartek.formacion.recetas.pojo;

public class Usuario {
	private long id;
	private String nombre;
	private String password;
	private String email;
	private String imagen;
	private String gitUserName;

	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "Anonimo";
		this.imagen = "http://kiwilandingpad.com/wp-content/uploads/2014/05/avatar-placeholder.png";
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", password=" + password + ", email=" + email + ", imagen="
				+ imagen + ", gitUserName=" + gitUserName + "]";
	}

}
