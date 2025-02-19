package launcher;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import modelo.Logica;
import modelo.Partido;
import vista.Impresion;
import vista.Lectura;

public class Menu {
	static Lectura sc = new Lectura();
	Map<String, ArrayList<Partido>> predicciones = new HashMap<>();
	ArrayList<Partido> real = new ArrayList<>();
	/**
	 * Menu de opciones
	 */
	public void menu() {
		boolean salir = false;
		while(!salir){
			Impresion.imprCSL("\n - Leer predicciones y data real (1)\n - Ver tablas(2)\n - Jugar(3)\n - Salir(4)");
			Impresion.imprSSL("¿Que opcion desea elegir? ");
			int opc = sc.leerInt();
		    Impresion.imprCSL("");
			switch(opc){
				case 1:
					if(predicciones.isEmpty()) {
						File[] archivosPr = sc.archivosPredicciones();
						int nJugadores = 1;
						for (int i = 0; i < archivosPr.length; i++) {
							Impresion.imprSSL("Jugador #" + nJugadores + ": ");
							String user = sc.leerString();
							predicciones.put(user, Logica.genPartidos(sc.lecturaTxt(archivosPr[i] + "")));
							nJugadores++;
						}
						Impresion.imprCSL("¡Bienvenidos al juego!");
						
						File archivoReal = sc.archivoReal();
						real = Logica.genPartidos(sc.lecturaTxt(archivoReal + ""));
						Impresion.imprCSL("¡Se registraron los valores reales!\n");
						
						File archivoPlantilla = sc.archivoPlantilla();
						Impresion.plantilla = sc.lecturaTxt(archivoPlantilla+"");
						
						for (Map.Entry<String, ArrayList<Partido>> entry : predicciones.entrySet()) {
							Logica.ordenTablas(new ArrayList<>(entry.getValue().subList(0, 48)), entry.getKey());
						}
						Logica.ordenTablas(new ArrayList<>(real.subList(0, 48)), "real");
					}else {
						Impresion.imprCSL("\n¡Ya se registraron las predicciones!\n");
					}
					break;
				case 2:
					if(!predicciones.isEmpty()) {
						menuTablas();	
					}else {
						Impresion.imprCSL("\n¡No se han ingresado predicciones!\n");
					}
					break;
				case 3:
					if(!predicciones.isEmpty()) {
						Logica.cuentasPuntos(real, predicciones);
						Impresion.imprCSL("Ver ranking de jugadores (puntos ganados)");
						Impresion.imprCSL("");
						Logica.ordenarPuntajes();
					}else {
						Impresion.imprCSL("\n¡No se han ingresado predicciones!\n");
					}
					break;
		       	case 4:
		       		Impresion.imprCSL("HAS SALIDO DEL SIMULADOR DEL MUNDIAL QATAR 2022");
		       		salir = true;
		       		break;
		       	default:
		       		Impresion.imprCSL("Digite una opcion valida");
       		}			
	   	}
	}
	/**
	 * Menu opciones para impresion de tablas
	 */
	public void menuTablas() {
		boolean salir = false;
		while(!salir) {
			Impresion.imprCSL("\n  TABLAS");
			Impresion.imprCSL("     - Jugadores (1)\n     - Real(2)\n     - Volver(3)");
			Impresion.imprSSL("     ¿Que opcion desea elegir? ");
			int opT = sc.leerInt();
			switch(opT) {
				case 1:
					for (Map.Entry<String, ArrayList<Partido>> entry : predicciones.entrySet()) {
						Impresion.imprCSL("  JUGADOR " + entry.getKey().toUpperCase());
						Impresion.imprTablas(entry.getKey());
						Impresion.generarFaseEliminatoria(new ArrayList<>(entry.getValue().subList(48, 64)));
					}
					break;
				case 2:
					if(!real.isEmpty()) {
						Impresion.imprCSL("  VALORES REALES");
						Impresion.imprTablas("real");
						Impresion.generarFaseEliminatoria(new ArrayList<>(real.subList(48, 64)));
					}
					break;
				case 3:
		       		salir = true;
					break;
				default:
					Impresion.imprCSL("Digite una opcion valida");
			}
		}
	}
}