package com.hbt.semillero.ejb;

import java.sql.Date;
import java.time.LocalDate;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.enums.EstadoEnum;

/**
 * <b>Descripción:<b> Clase que determina la gestión de la compra de un Comic.
 * <b>Caso de Uso: CU-2021<b>
 * 
 * @author David Navia
 * @version 1.0
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarCompraComicBean implements IGestionarCompraComicLocal {
	
	/**
	 * Se define la entidad de manejo de datos.
	 */
	@PersistenceContext
	public EntityManager em;

	/**
	 * Metodo encargado de comprar un comicy retornar su DTO.
	 * @see com.hbt.semillero.ejb.IGestionarCompraComicLocal#comprarComic(java.lang.Long, java.lang.Long)
	 */
	@Override
	public ComicDTO comprarComic(Long idComic, Long cantidad) throws Exception {
		String consultaUnComic = " SELECT c FROM Comic c WHERE c.id = :idComic ";
		Query consultaNativa = em.createQuery(consultaUnComic);
		consultaNativa.setParameter("idComic", idComic);
		Comic comicAComprar = (Comic) consultaNativa.getSingleResult();
		ComicDTO comicDTO = null;
		comicDTO = this.convertirComicToComicDTO(comicAComprar);
		String cantidadComicExistente = String.valueOf(comicDTO.getCantidad());
		if (comicDTO.getCantidad() < cantidad) {
			throw new Exception("La cantidad existente del comic es: " + cantidadComicExistente
					+ " numeroComics, y supera la ingresada" + cantidad);
		}
		if (comicDTO.getEstadoEnum() == EstadoEnum.INACTIVO) {
			throw new Exception("El comic seleccionado no cuenta con stock en bodega");
		}
		if (comicDTO.getCantidad() == cantidad) {
			LocalDate hoy = LocalDate.now();
			comicDTO.setFechaVenta(hoy);
			Long nuevaCantidad = comicDTO.getCantidad() - cantidad;
			comicDTO.setCantidad(nuevaCantidad);
			comicDTO.setEstadoEnum(EstadoEnum.INACTIVO);
			comicAComprar = this.convertirComicDTOToComic(comicDTO);
			em.merge(comicAComprar);
		}
		if (comicDTO.getCantidad() > cantidad && comicDTO.getCantidad() != cantidad) {
			LocalDate hoy = LocalDate.now();
			comicDTO.setFechaVenta(hoy);
			Long nuevaCantidad = comicDTO.getCantidad() - cantidad;
			comicDTO.setCantidad(nuevaCantidad);
			comicAComprar = this.convertirComicDTOToComic(comicDTO);
			em.merge(comicAComprar);
		}
		return comicDTO;
	}


	/**
	 * 
	 * Metodo encargado de transformar un comic a un comicDTO
	 * 
	 * @param comic
	 * @return
	 */
	private ComicDTO convertirComicToComicDTO(Comic comic) {
		ComicDTO comicDTO = new ComicDTO();
		comicDTO.setId(comic.getId());
		comicDTO.setNombre(comic.getNombre());
		comicDTO.setEditorial(comic.getEditorial());
		comicDTO.setTematicaEnum(comic.getTematicaEnum());
		comicDTO.setColeccion(comic.getColeccion());
		comicDTO.setNumeroPaginas(comic.getNumeroPaginas());
		comicDTO.setPrecio(comic.getPrecio());
		comicDTO.setAutores(comic.getAutores());
		comicDTO.setColor(comic.getColor());
		comicDTO.setFechaVenta(comic.getFechaVenta());
		comicDTO.setEstadoEnum(comic.getEstadoEnum());
		comicDTO.setCantidad(comic.getCantidad());
		return comicDTO;
	}

	/**
	 * 
	 * Metodo encargado de transformar un comicDTO a un comic
	 * 
	 * @param comic
	 * @return
	 */
	private Comic convertirComicDTOToComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
		comic.setId(comicDTO.getId());
		comic.setNombre(comicDTO.getNombre());
		comic.setEditorial(comicDTO.getEditorial());
		comic.setTematicaEnum(comicDTO.getTematicaEnum());
		comic.setColeccion(comicDTO.getColeccion());
		comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
		comic.setPrecio(comicDTO.getPrecio());
		comic.setAutores(comicDTO.getAutores());
		comic.setColor(comicDTO.getColor());
		comic.setFechaVenta(comicDTO.getFechaVenta());
		comic.setEstadoEnum(comicDTO.getEstadoEnum());
		comic.setCantidad(comicDTO.getCantidad());
		return comic;
	}

}
