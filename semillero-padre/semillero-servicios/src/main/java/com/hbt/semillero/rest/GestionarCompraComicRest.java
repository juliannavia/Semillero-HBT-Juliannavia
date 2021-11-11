package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.IGestionarComicLocal;
import com.hbt.semillero.ejb.IGestionarCompraComicLocal;

/**
 * <b>Descripción:<b> Clase que determina la gestion de la compra de un Comic con REST.
 * <b>Caso de Uso: CU-2021<b> 
 * @author David Navia
 * @version 1.0
 */
@Path("/gestionarCompraComic")
public class GestionarCompraComicRest {
	@EJB
	private IGestionarCompraComicLocal gestionarCompraComicLocal;
	@POST
	@Path("/comprarComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ComicDTO comprarComic(Long id, Long cantidad) {
		ComicDTO resultadoDTOEjecucion = new ComicDTO();
		try {
			resultadoDTOEjecucion = this.gestionarCompraComicLocal.comprarComic(id, cantidad);
			resultadoDTOEjecucion.setExitoso(true);
			resultadoDTOEjecucion.setMensajeEjecucion("La compra del comic fue exitosa");
		} catch (Exception e) {
			resultadoDTOEjecucion.setExitoso(false);
			resultadoDTOEjecucion.setMensajeEjecucion("La compra del comic no fue exitosa");
		}
		return resultadoDTOEjecucion;
	}
}
