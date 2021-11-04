package com.hbt.semillero.enums;


/**
 * <b>Descripción:<b> Clase que determina la enumeración para representarel estado de un Comic
 * <b>Caso de Uso:<b> 
 * @author David Navia
 * @version 1.0
 */
public enum EstadoEnum {
	ACTIVO("enum.estado.activo"), 
	INACTIVO("enum.estado.inactivo"),
	;
	
	private String estado;
	
	EstadoEnum(String estado){
		this.estado = estado;
	}
	
	public String getEstado() {
		return estado;
	}
}
