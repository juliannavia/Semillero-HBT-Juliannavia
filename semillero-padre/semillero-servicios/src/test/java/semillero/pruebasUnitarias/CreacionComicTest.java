package semillero.pruebasUnitarias;

import java.lang.reflect.Array;
import java.math.BigDecimal;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.enums.TematicaEnum;

import junit.framework.Assert;

/**
 * <b>Descripción:<b> Clase que determina la creacion de un test unitario para la entidad Comic
 * <b>Caso de Uso: SEMILLERO 2021<b> 
 * @author David Navia
 * @version 1.0
 */
@Test
public class CreacionComicTest {
	private final static Logger log = Logger.getLogger(CreacionComicTest.class);
	
	/**
	 * Metodo encargado de inicializar el Log para el manejo de logs.
	 * <b>Caso de Uso</b> CU-2021
	 * @author David Navia
	 *
	 */
	@BeforeTest
	public void inicializar() {
		BasicConfigurator.configure(); //Inicializo el Logger con una configuración básica.
		log.info(":::::::::::::::::::::::: INICIAN LAS PRUEBAS UNITARIAS ::::::::::::::::::::::::::::::::");
	}
	
	/**
	 * Metodo encargado de crear un listado de 10 Comics para ser testeados, diferenciandose si están activos o no.
	 * <b>Caso de Uso</b> CU-2021
	 * @author David Navia
	 * 
	 * @return Array de Comics
	 */
	public ComicDTO[] crearComics(){
		ComicDTO comicDTO1 = new ComicDTO("1","EL GRAN COMIC 1","MarvelComics",TematicaEnum.AVENTURAS,"Primera",new Integer(99),new BigDecimal(1000000),"Adam Smith",true,EstadoEnum.DISPONIBLE, new Long(1));
		ComicDTO comicDTO2 = new ComicDTO("1","EL GRAN COMIC 1","MarvelComics",TematicaEnum.AVENTURAS,"Primera",new Integer(99),new BigDecimal(1000000),"Adam Smith",true,EstadoEnum.DISPONIBLE, new Long(1));
		ComicDTO comicDTO3 = new ComicDTO("1","EL GRAN COMIC 1","MarvelComics",TematicaEnum.AVENTURAS,"Primera",new Integer(99),new BigDecimal(1000000),"Adam Smith",true,EstadoEnum.DISPONIBLE, new Long(1));
		ComicDTO comicDTO4 = new ComicDTO("1","EL GRAN COMIC 1","MarvelComics",TematicaEnum.AVENTURAS,"Primera",new Integer(99),new BigDecimal(1000000),"Adam Smith",true,EstadoEnum.NODISPONIBLE, new Long(1));
		ComicDTO comicDTO5 = new ComicDTO("1","EL GRAN COMIC 1","MarvelComics",TematicaEnum.AVENTURAS,"Primera",new Integer(99),new BigDecimal(1000000),"Adam Smith",true,EstadoEnum.DISPONIBLE, new Long(1));
		ComicDTO comicDTO6 = new ComicDTO("1","EL GRAN COMIC 1","MarvelComics",TematicaEnum.AVENTURAS,"Primera",new Integer(99),new BigDecimal(1000000),"Adam Smith",true,EstadoEnum.DISPONIBLE, new Long(1));
		ComicDTO comicDTO7 = new ComicDTO("1","EL GRAN COMIC 1","MarvelComics",TematicaEnum.AVENTURAS,"Primera",new Integer(99),new BigDecimal(1000000),"Adam Smith",true,EstadoEnum.NODISPONIBLE, new Long(1));
		ComicDTO comicDTO8 = new ComicDTO("1","EL GRAN COMIC 1","MarvelComics",TematicaEnum.AVENTURAS,"Primera",new Integer(99),new BigDecimal(1000000),"Adam Smith",true,EstadoEnum.DISPONIBLE, new Long(1));
		ComicDTO comicDTO9 = new ComicDTO("1","EL GRAN COMIC 1","MarvelComics",TematicaEnum.AVENTURAS,"Primera",new Integer(99),new BigDecimal(1000000),"Adam Smith",true,EstadoEnum.NODISPONIBLE, new Long(1));
		ComicDTO comicDTO10 = new ComicDTO("1","EL GRAN COMIC 1","MarvelComics",TematicaEnum.AVENTURAS,"Primera",new Integer(99),new BigDecimal(1000000),"Adam Smith",true,EstadoEnum.NODISPONIBLE, new Long(1));
		
		ComicDTO[] comics = new ComicDTO[10];
		comics[0] = comicDTO1;
		comics[1] = comicDTO2;
		comics[2] = comicDTO3;
		comics[3] = comicDTO4;
		comics[4] = comicDTO5;
		comics[5] = comicDTO6;
		comics[6] = comicDTO7;
		comics[7] = comicDTO8;
		comics[8] = comicDTO9;
		comics[9] = comicDTO10;
		
		return comics;
	}
	
	/**
	 * Metodo encargado de verificar si los comics están activos con un test unitario.
	 * <b>Caso de Uso</b> CU-2021
	 * @author David Navia
	 * @return listado de Comics activos.
	 */
	@Test
	private ComicDTO[] verificarComicsActivos() {
		log.info("inicio TEST verificarComicsActivos()");
		int indice = 0; //Variable que se encarga de asignar un indice al array que contendrá los comics activos.
		ComicDTO[] comics = crearComics();
		//For donde busco cuantos comics están disponibles
		for (int i = 0; i < comics.length; i++) {
			if(comics[i].getEstadoEnum() == EstadoEnum.DISPONIBLE) {
				indice++;
			}
		}
		//Se crea el arreglo de comics activos
		ComicDTO[] comicsActivos = new ComicDTO[indice];
		
		//Se busca y compara entre los comics cual está activo y cual no.
		for (int i = 0; i < comics.length; i++) {
			if(comics[i].getEstadoEnum() == EstadoEnum.DISPONIBLE) {
				for (int j = 0; j < comicsActivos.length; j++) {
					comicsActivos[j] = comics[i];
					Assert.assertEquals(comicsActivos[j].getEstadoEnum(),EstadoEnum.NODISPONIBLE);
					
				}
			}
		}
		log.info("fin TEST verificarComicsActivos()");
		return comicsActivos;
	}
	
	/**
	 * Metodo encargado de verificar si los comics están inactivos con un test unitario.
	 * <b>Caso de Uso</b> CU-2021
	 * @author David Navia
	 * @return Array de Comics inactivos
	 * @throws Exception excepcion lanzada cuando los comics que deberian ser inactivos no lo son
	 */
	private ComicDTO[] verificarComicsInactivos() throws Exception{
		
		int indice = 0; //Variable que se encarga de asignar un indice al array que contendrá los comics inactivos.
		
		ComicDTO[] comics = crearComics(); //llamado a todos los comics
		
		int totalComics = comics.length; //variable que entrega cuantos comics hay en total
		
		String nombresComicsInactivos = ""; //variable que define los nombres de los comics inactivos para luego ser llamados en la excepcion
		
		
		
		//For donde busco cuantos comics están disponibles
		for (int i = 0; i < comics.length; i++) {
			if(comics[i].getEstadoEnum() == EstadoEnum.NODISPONIBLE) {
				indice++;
			}
		}
		
		int totalInactivos = indice; //variable que indica el total de inactivos que hay
		
		int totalActivos = totalComics - totalInactivos; //variable que indica el total de comics activos que hay
		
		ComicDTO[] comicsInactivos = new ComicDTO[indice]; //creacion del arreglo a retornar con los comics activos
		
		//for donde se busca y compara entre los comics inactivos para poder mandar una excepcion en caso de que aparezca uno activo.
			for (int i = 0; i < comics.length; i++) {
				if(comics[i].getEstadoEnum() == EstadoEnum.NODISPONIBLE) {
					for (int j = 0; j < comicsInactivos.length; j++) {
						comicsInactivos[j] = comics[i];
						nombresComicsInactivos = nombresComicsInactivos + comicsInactivos[j].getNombre(); //se llena la variable de nombres
					}
				}  else {
					//se detecta un error y se manda una excepcion.
					throw new Exception("Se ha detectado que de " + totalComics + " comics se encontraron que" + totalActivos + " se encuentran activos y" + totalInactivos + "inactivos. Los comics inactivos son: " + nombresComicsInactivos );
				}
			}
		//retorno del arreglo de inactivos.	
		return comicsInactivos;
	}
	
	//fin de la prueba unitaria.
	@AfterTest
	public void finalizarPruebasUnitarias() {
		log.info(":::::::::::::::::::::::: finalizan LAS PRUEBAS UNITARIAS ::::::::::::::::::::::::::::::::");
	}

}
