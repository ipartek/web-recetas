package com.ipartek.formacion.recetas.pojo;

public class Usuario {

	// ATRIBUTOS
	private long id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int edad;
	private String dni;
	private String email;
	private String puesto;
	private String password;
	private String imagen;
	private String gitUserName;

	// CONSTRUCTORES
	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "anonimo";
		this.imagen = "https://pbs.twimg.com/profile_images/617295207202209792/P8kGVpP-_reasonably_small.png";
	}

	public Usuario(long id) {
		super();
		this.id = id;
	}

	public Usuario(String nombre) {
		super();
		this.nombre = nombre;
		this.imagen = "https://pbs.twimg.com/profile_images/617295207202209792/P8kGVpP-_reasonably_small.png";
	}

	public Usuario(String nombre, String imagen) {
		super();
		this.nombre = nombre;
		this.imagen = imagen;
	}

	// GETTERS AND SETTERS

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

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
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

	// TO STRING
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", edad=" + edad + ", dni=" + dni + ", email=" + email + ", puesto=" + puesto + ", password="
				+ password + ", imagen=" + imagen + ", gitUserName=" + gitUserName + "]";
	}

}
