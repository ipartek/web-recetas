package com.ipartek.formacion.recetas.pojo;

import java.util.ArrayList;

public class Receta implements Comparable<Receta>{

	//Declaracion
	public static final String FACIL = "facil";
	public static final String MODERADO = "moderado";
	public static final String DIFICIL = "dificil";
	private long id;
	private ArrayList<Ingrediente> ingredientes;
	private String titulo;
	private int tiempo;
	private String dificultad;
	private int comensales;
	private String descripcion;
	private String imagen;
	public String IMG_DEFAULT = "https://media.licdn.com/mpr/mpr/shrink_200_200/AAEAAQAAAAAAAASOAAAAJDc3ZTk5YWNhLWU4MGQtNDUyNi04MTU0LWYyN2Q0NjZjZjY3ZA.png";

	//Constructor titulo
	
	public Receta() {
		super();
		this.id= -1;
		this.titulo = "";
		this.imagen = IMG_DEFAULT;
		setIngredientes(null);
		this.tiempo = 0;
		this.comensales = 0;
		this.dificultad = "facil";
		this.descripcion = "Lorem ipsum....";
	}
	
	public Receta(String titulo) {
		super();
		this.titulo = titulo;
		this.imagen = IMG_DEFAULT;
		setIngredientes(null);
		this.tiempo = 0;
		this.comensales = 0;
		this.dificultad = "facil";
		this.descripcion = "Lorem ipsum....";
	}

	

	//Constructor +ingredientes
	public Receta(String titulo, ArrayList<Ingrediente> ingredientes) {
		super();
		this.titulo = titulo;
		this.imagen = IMG_DEFAULT;
		setIngredientes(ingredientes);
		this.tiempo = 0;
		this.comensales = 0;
		this.dificultad = "facil";
		this.descripcion = "Lorem ipsum....";
	}

	/**Nos indica si la receta esta libre de ingredientes con gluten
	 * @return true si algun ingrediente en la receta contiene gluten*/
	public boolean isGlutenFree() {
		boolean resul = true;
		if (this.ingredientes != null) {
			for (Ingrediente i : this.ingredientes) {
				if (i.isGluten()) {
					resul = false;
					break;
				}
			}
		}
		return resul;
	}

	/** Comprueba si contiene elIngrediente pasado como parametro
	 * @return true si contiene ingrediente*/
	public boolean contiene(Ingrediente ingrendiente) {
		boolean resul = false;
		if (ingrendiente != null) {
			final String NOMBRE_RECETA_BUSCAR = ingrendiente.getNombre();
			for (Ingrediente iterateIngredient : ingredientes) {
				if (NOMBRE_RECETA_BUSCAR.equalsIgnoreCase(iterateIngredient.getNombre())) {
					resul = true;
					break;
				}
			}
		}
		return resul;
	}

	/**Añade Ingrediente
	 * @param ingrendiente si es null no hace nada*/
	public void addIngrendiente(Ingrediente ingrendiente) {
		if (ingrendiente != null) {
			this.ingredientes.add(ingrendiente);
		}
	}

	/**Eliminar el primer ingrendiente que encuentre con el mismo <code>nombre</code> CaseInsesitive
	 * @return true si elimina ingrediente*/
	public boolean removeIngrendiente(Ingrediente ingrendiente) {
		boolean resul = false;
		if (ingrendiente != null) {
			final String NOMBRE_INGREDIENTE_ELIMINAR = ingrendiente.getNombre();
			Ingrediente iterateIngredient = null;
			for (int i = 0; i < this.ingredientes.size(); i++) {
				iterateIngredient = this.ingredientes.get(i);
				if (NOMBRE_INGREDIENTE_ELIMINAR.equalsIgnoreCase(iterateIngredient.getNombre())) {
					this.ingredientes.remove(i);
					resul = true;
					break;
				}
			} 
		} 
		return resul;
	}

	//Getter & Setter
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {

		this.ingredientes = (ingredientes == null) ? new ArrayList<Ingrediente>() : ingredientes;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public String getDificultad() {
		return dificultad;
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}

	public int getComensales() {
		return comensales;
	}

	public void setComensales(int comensales) {
		this.comensales = comensales;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	//Ordenar Array A-Z
	@Override
	public int compareTo(Receta o) {		
		return this.getTitulo().toLowerCase().compareTo(o.getTitulo().toLowerCase());
	}

	//toString()
	@Override
	public String toString() {
		return "Receta [titulo=" + titulo + ", imagen=" + imagen + ", ingredientes=" + ingredientes + ", tiempo="
				+ tiempo + ", dificultad=" + dificultad + ", comensales=" + comensales + ", descripcion=" + descripcion
				+ "]";
	}

	
}