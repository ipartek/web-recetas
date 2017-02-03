package com.ipartek.formacion.recetas.pojo;

public class PersonaBBDD {
	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int edad;
	private String email;
	private String dni;
	private String puesto;

	public PersonaBBDD() {
		super();
	}

	public PersonaBBDD(int id, String nombre, String apellido1, String apellido2, int edad, String email, String dni,
			String puesto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.edad = edad;
		this.email = email;
		this.dni = dni;
		this.puesto = puesto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Override
	public String toString() {
		return "PersonaBBDD [id=" + id + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", edad=" + edad + ", dni=" + dni + ", puesto=" + puesto + "]";
	}

}
