package com.ipartek.formacion.recetas.pojo;

public class DadoAlumno {

	private long id;
	private String alumno;

	public DadoAlumno() {
		super();
	}

	public DadoAlumno(String alumno, long id) {
		super();
		this.alumno = alumno;
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAlumno() {
		return alumno;
	}

	public void setAlumno(String alumno) {
		this.alumno = alumno;
	}

	@Override
	public String toString() {
		return "DadoAlumno [id=" + id + ", alumno=" + alumno + "]";
	}

}
