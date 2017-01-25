package com.ipartek.formacion.recetas.pojo;

public class Usuario {

	private long id;
	private String nombre;
	private String email;
	private String password;
	private String imagen;
	private String gitUserName;
	
	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "anonimo";
		this.imagen= "http://cdn.akamai.steamstatic.com/steamcommunity/public/images/avatars/98/9806f1ff88dc34fafe922687deeaa2fa6d2d3203_medium.jpg";
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return "Usuario [id=" + id + ", nombre=" + nombre + ", email=" + email + ", password=" + password + ", imagen="
				+ imagen + ", gitUserName=" + gitUserName + "]";
	}
	
	
}
