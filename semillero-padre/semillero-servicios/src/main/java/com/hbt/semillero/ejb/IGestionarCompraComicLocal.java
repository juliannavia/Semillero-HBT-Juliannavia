package com.hbt.semillero.ejb;

import javax.ejb.Local;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;

/**
 * <b>Descripción:<b> Interfaz que determina la gestion del servicio comprar un comic.
 * <b>Caso de Uso: CU-2021<b> 
 * @author David Navia
 * @version 1.0
 */
@Local
public interface IGestionarCompraComicLocal {
	
	/**
	 * Metodo encargado de gestionar la compra de un comic.
	 * <b>Caso de Uso: CU-2021</b>
	 * @author David Navia
	 * 
	 * @param idComic id del comic que se quiere comprar.
	 * @param cantidad cantidad que se quiere comprar de este comic.
	 * @return
	 * @throws Exception 
	 */
	public ComicDTO comprarComic(Long idComic, Long cantidad) throws Exception;
}

