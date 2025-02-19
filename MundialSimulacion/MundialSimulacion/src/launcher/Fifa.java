package launcher;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
//import java.util.Scanner;

import modelo.Logica;
import modelo.Partido;
import vista.EyS;

public class Fifa {
	
	Random r = new Random();
	static EyS sc = new EyS();
	Map<String, ArrayList<Partido>> predicciones = new HashMap<>();
	ArrayList<Partido> real = new ArrayList<>();
	//ArrayList<ArrayList<Partido>> predicciones = new ArrayList<>();
	//ArrayList<Partido> partidos = new ArrayList<>();

	public static void main(String[] args) {
		Fifa c = new Fifa();
		sc.imprCSL("---- SIMULADOR DEL MUNDIAL QATAR 2022 ----");
		c.menu();
	}
	
	/**
	 * Menu de opciones
	 */
	public void menu() {
		boolean salir = false;
		
		while(!salir){
			sc.imprCSL("\n - Leer predicciones y data real (1)\n - Ver tablas(2)\n - Jugar(3)\n - Ver clasificaciones de jugadores(4)\n - Salir(5)");
			sc.imprSSL("¿Que opcion desea elegir? ");
			int opc = sc.leerInt();
		    System.out.println();
			boolean AJugar = false;
			switch(opc){
				case 1:
					if(predicciones.isEmpty()) {
						File[] archivosPr = sc.archivosPredicciones();
						int nJugadores = 1;
						for (int i = 0; i < archivosPr.length; i++) {
							System.out.print("Jugador #" + nJugadores + ": ");
							String user = sc.leerString();
							predicciones.put(user, Logica.genPartidos(sc.lecturaTxt(archivosPr[i] + "")));
							nJugadores++;
						}
						System.out.println("¡Bienvenidos al juego!");
						
						File archivoReal = sc.archivoReal();
						real = Logica.genPartidos(sc.lecturaTxt(archivoReal + ""));
						System.out.println("¡Se registraron los valores reales!\n");
						/*for (Map.Entry<String, ArrayList<Partido>> entry : predicciones.entrySet()) {
							System.out.println("Jugador " + entry.getKey());
							Logica.imprP(entry.getValue());
							System.out.println();
							//System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
						}*/
					}else {
						System.out.println("\n¡Ya se registraron las predicciones!\n");
					}
					
					break;
				case 2:
					if(!predicciones.isEmpty()) {
						/*for (Map.Entry<String, ArrayList<Partido>> entry : predicciones.entrySet()) {
							System.out.println("Jugador " + entry.getKey());
							Logica.ordenTablas(new ArrayList<>(entry.getValue().subList(0, 48)));
							Logica.imprTablas();
							Logica.generarFaseEliminatoria(new ArrayList<>(entry.getValue().subList(48, 64)));
						}*/
						menuTablas();	
					}else {
						sc.imprCSL("\n¡No se han ingresado predicciones!\n");
					}
					/*if(!real.isEmpty()) {
						System.out.println("VALORES REALES");
						Logica.ordenTablas(new ArrayList<>(real.subList(0, 48)));
						Logica.imprTablas();
						Logica.generarFaseEliminatoria(new ArrayList<>(real.subList(48, 64)));
					}*/
					break;
				case 3:
					if(!predicciones.isEmpty()) {
						System.out.println("\nCelebralo Curramba\n");
						AJugar  = true;
					}else {
						System.out.println("\n¡No se han ingresado predicciones!\n");
					}
					break;
				case 4:
					if(!predicciones.isEmpty()) {
						System.out.println("Ver ranking de jugadores (puntos ganados)");
					}else {
						System.out.println("\n¡No se han ingresado predicciones!\n");
					}
					break;
		       	case 5:
		       		sc.imprCSL("HAS SALIDO DEL SIMULADOR DEL MUNDIAL QATAR 2022");
		       		salir = true;
		       		break;
		       	default:
		       		sc.imprCSL("Digite una opcion valida");
       		}
			if(AJugar) {
				System.out.println("Predecir");
			}
			
	   	}
	}
	
	public void menuTablas() {
		boolean salir = false;
		while(!salir) {
			sc.imprCSL("\n  TABLAS");
			sc.imprCSL("     - Jugadores (1)\n     - Real(2)\n     - Volver(3)");
			sc.imprSSL("     ¿Que opcion desea elegir? ");
			int opT = sc.leerInt();
			switch(opT) {
				case 1:
					for (Map.Entry<String, ArrayList<Partido>> entry : predicciones.entrySet()) {
						System.out.println("  JUGADOR " + entry.getKey().toUpperCase());
						Logica.ordenTablas(new ArrayList<>(entry.getValue().subList(0, 48)));
						Logica.imprTablas();
						Logica.generarFaseEliminatoria(new ArrayList<>(entry.getValue().subList(48, 64)));
					}
					/**
					 * Nota (obtener subList, es decir, entry.getValue().subList(,)):
					 * Del 0 al 48 se obtienen los partidos de fase grupos : entry.getValue().subList(48, 64)
					 * Del 48 al 56 se obtienen los partidos de octavos : entry.getValue().subList(48, 56)
					 * Del 56 al 60 se obtienen los partidos de cuartos : entry.getValue().subList(56, 60)
					 * Del 60 al 62 se obtienen los partidos de semis : entry.getValue().subList(60, 62)
					 * Del 62 al 63 se obtiene el partido de tercer puesto : entry.getValue().subList(62, 63)
					 * Del 63 al 64 se obtiene el partido de la final : entry.getValue().subList(63, 64)
					 * 
					 * o se puede tambien entry.getValue().get(62) para obtener el partido de tercer puesto
					 * y entry.getValue().get(63) para obtener el partido de la final
					 */
					break;
				case 2:
					if(!real.isEmpty()) {
						System.out.println("  VALORES REALES");
						Logica.ordenTablas(new ArrayList<>(real.subList(0, 48)));
						Logica.imprTablas();
						Logica.generarFaseEliminatoria(new ArrayList<>(real.subList(48, 64)));
					}
					break;
				case 3:
		       		salir = true;
					break;
				default:
					sc.imprCSL("Digite una opcion valida");
			}
		}
	}
	
	/**
	 * if(AJugar) {
				String fase = "";
				for (int i = 0; i < partidos.size(); i++) {
					if(!partidos.get(i).getFase().equals(fase)) {
						sc.imprCSL("\nFase: " + partidos.get(i).getFase().toUpperCase());
						fase = partidos.get(i).getFase();
					}
					sc.imprCSL("\n  " + partidos.get(i).getEquipo1() + " vs " + partidos.get(i).getEquipo2());
					sc.imprCSL("  - Resultado: " + partidos.get(i).getResultado());
					sc.imprCSL("  - Ganador: " + partidos.get(i).getGanador());
				}
				sc.imprCSL("\n-------------------------------");
			}
	 */
}
