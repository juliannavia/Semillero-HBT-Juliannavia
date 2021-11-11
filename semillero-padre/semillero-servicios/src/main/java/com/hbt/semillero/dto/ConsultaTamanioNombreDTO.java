package com.hbt.semillero.dto;

import java.util.ArrayList;

/**
 * <b>Descripción:<b> Clase que determina la consulta de dos listas con los nombres de los Comics que sean mayores y menores a la longitud.
 * <b>Caso de Uso: CU 2021<b> 
 * @author David Navia
 * @version
 */
public class ConsultaTamanioNombreDTO extends ResultadoDTO {
	private static final long serialVersionUID = 1L;
	private ArrayList<String> comicsArribaDelTamanio;
	private ArrayList<String> comicsAbajoDelTamanio;
	
	
	/**
	 * Constructor de la clase DTO inicializando arreglos.
	 * @param comicsArribaDelTamanio Aqui se guardan los comics por arriba de la longitud.
	 * @param comicsAbajoDelTamanio Aqui se guardan los comics por abajo de la longitud.
	 */
	public ConsultaTamanioNombreDTO() {
		super();
		this.comicsArribaDelTamanio = new ArrayList<String>();
		this.comicsAbajoDelTamanio = new ArrayList<String>();
	}
	
	// Getters and Setters //

	public ArrayList<String> getComicsArribaDelTamanio() {
		return comicsArribaDelTamanio;
	}

	public void setComicsArribaDelTamanio(ArrayList<String> comicsArribaDelTamanio) {
		this.comicsArribaDelTamanio = comicsArribaDelTamanio;
	}

	public ArrayList<String> getComicsAbajoDelTamanio() {
		return comicsAbajoDelTamanio;
	}

	public void setComicsAbajoDelTamanio(ArrayList<String> comicsAbajoDelTamanio) {
		this.comicsAbajoDelTamanio = comicsAbajoDelTamanio;
	}
	
}
