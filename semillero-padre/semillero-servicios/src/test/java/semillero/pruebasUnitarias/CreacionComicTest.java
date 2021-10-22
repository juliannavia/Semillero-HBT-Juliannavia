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

public class CreacionComicTest {
	
	public static void main(String[] args) {


		CreacionComicTest test1 = new CreacionComicTest();
		test1.leerComicsActivos();

	}

	
	public CreacionComicTest() {
		
	}
	
	private final static Logger log = Logger.getLogger(CreacionComicTest.class);
	
	@BeforeTest
	public void inicializar() {
		BasicConfigurator.configure(); //Inicializo el Logger con una configuración básica.
		log.info(":::::::::::::::::::::::: INICIAN LAS PRUEBAS UNITARIAS ::::::::::::::::::::::::::::::::");
	}

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
	
	private ComicDTO[] verificarComicsActivos() {
		int indice = 0;
		
		ComicDTO[] comics = crearComics();
		
		//For donde busco cuantos comics están disponibles
		for (int i = 0; i < comics.length; i++) {
			if(comics[i].getEstadoEnum() == EstadoEnum.DISPONIBLE) {
				indice++;
			}
		}
		
		ComicDTO[] comicsActivos = new ComicDTO[indice];
		
		for (int i = 0; i < comics.length; i++) {
			if(comics[i].getEstadoEnum() == EstadoEnum.DISPONIBLE) {
				for (int j = 0; j < comicsActivos.length; j++) {
					comicsActivos[j] = comics[i];
				}
			}
		}
		
		return comicsActivos;
	}
	
	@Test
	private ComicDTO[] verificarComicsActivosTEST() {
		
		log.info("Inicia ejecución del método verificarComicsActivosTEST()");
		int indice = 0;
		
		ComicDTO[] comics = crearComics();
		
		
		for (int i = 0; i < comics.length; i++) {
			Assert.assertEquals(EstadoEnum.DISPONIBLE, comics[i].getEstadoEnum());
		}
		
		log.info("termina ejecución del método verificarComicsActivosTEST()");
		
		//For donde busco cuantos comics están disponibles
		for (int i = 0; i < comics.length; i++) {
			if(comics[i].getEstadoEnum() == EstadoEnum.DISPONIBLE) {
				indice++;
			}
		}
		
		ComicDTO[] comicsActivos = new ComicDTO[indice];
		
		for (int i = 0; i < comics.length; i++) {
			if(comics[i].getEstadoEnum() == EstadoEnum.DISPONIBLE) {
				for (int j = 0; j < comicsActivos.length; j++) {
					comicsActivos[j] = comics[i];
				}
			}
		}
		
		
		
		
		return comicsActivos;
		
		
	}
	
	private ComicDTO[] verificarComicsInactivos() {
		int indice = 0;
		
		ComicDTO[] comics = crearComics();
		
		//For donde busco cuantos comics están disponibles
		for (int i = 0; i < comics.length; i++) {
			if(comics[i].getEstadoEnum() == EstadoEnum.NODISPONIBLE) {
				indice++;
			}
		}
		
		ComicDTO[] comicsInactivos = new ComicDTO[indice];
		
		for (int i = 0; i < comics.length; i++) {
			if(comics[i].getEstadoEnum() == EstadoEnum.NODISPONIBLE) {
				for (int j = 0; j < comicsInactivos.length; j++) {
					comics[j] = comics[i];
				}
			}
		}
		
		return comicsInactivos;
	}
	
	@Test
	private ComicDTO[] verificarComicsInactivosTEST() {
		int indice = 0;
		
		ComicDTO[] comics = crearComics();
		int comicsEnTotal = comics.length-1;
		
		
		//For donde busco cuantos comics están disponibles
		for (int i = 0; i < comics.length; i++) {
			if(comics[i].getEstadoEnum() == EstadoEnum.NODISPONIBLE) {
				indice++;
			}
		}
		int comicsActivos = comicsEnTotal - indice;
		int comicsInactivosIndice = indice;
		
		try {
			
				if(true) {
					throw new Exception("Se ha detectado que de:" + comics.length + "Comics se encontraron que" + comicsActivos + "se encuentran activos y " + comicsInactivosIndice + "inactivos" + "los comics inactivos son:");
				}
			
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(),"Detectando comics inactivos");
		}
		
		ComicDTO[] comicsInactivos = new ComicDTO[indice];
		
		for (int i = 0; i < comics.length; i++) {
			if(comics[i].getEstadoEnum() == EstadoEnum.NODISPONIBLE) {
				for (int j = 0; j < comicsInactivos.length; j++) {
					comics[j] = comics[i];
				}
			}
		}
		
		return comicsInactivos;
	}
	
	private void leerComicsActivos() {
		ComicDTO[] comics = verificarComicsActivos();
		for (int i = 0; i < comics.length; i++) {
			System.out.println(comics[i]);
		}
	}
	
	@AfterTest
	public void finalizarPruebasUnitarias() {
		log.info(":::::::::::::::::::::::: finalizan LAS PRUEBAS UNITARIAS ::::::::::::::::::::::::::::::::");
	}
	
	
}
