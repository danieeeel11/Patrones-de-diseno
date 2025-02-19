package creator;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Launcher {
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Launcher l = new Launcher();
		System.out.print("---- CREADOR DE PERSONAJES ----");
		l.menu();
	}
	
	/**
	 * Menu de opciones
	 */
	public void menu() {
		boolean salir = false;
		
		while(!salir){
			System.out.println("\n\n5 grupos de posibilidades:");
			System.out.println("  - Robot(1)\n  - Superheroe(2)\n  - Futbolista(3)\n  - Profesional(4)\n  - Caricatura(5)\n  - Salir(6)");
			System.out.print("¿Que grupo desea elegir? ");
			int opc = sc.nextInt();
		    
			AbstractFactory factory = null;
			ArrayList<String> conjunto = null;
			switch(opc){
		       	case 1:
		       		factory = new CreadorRobot();
		       		conjunto = genRobot();
		       		break;
		       	case 2:
		       		factory = new CreadorSuperheroe();
		       		conjunto = genSuperheroe();
		       		break;
		       	case 3:
		       		factory = new CreadorFubolista();
		       		conjunto = genFutbolista();
		       		break;
		       	case 4:
		       		factory = new CreadorProfesional();
		       		conjunto = genProfesional();
		       		break;
		       	case 5:
		       		factory = new CreadorCaricatura();
		       		conjunto = genCaricatura();
		       		break;
		       	case 6:
		       		System.out.println("HAS SALIDO DEL CREADOR DE PERSONAJES");
		       		salir=true;
		       		break;
		       	default:
		       		System.out.println("Digite una opcion valida");
       		}
			if(opc<6) {
				IPersonaje p = factory.crearPersonaje(conjunto.get(0), conjunto.get(1), conjunto.get(2), conjunto.get(3), conjunto.get(4), conjunto.get(5), conjunto.get(6));
				p.eNombre();
				p.eCabeza();
				p.eAccCabeza();
				p.eDorso();
				p.eAccDorso();
				p.ePiernas();
				p.eAccPiernas();
				System.out.println("\n-------------------------------");
			}
			
	   	}
	}
	
	/**
	 * Metodo random de eleccion de partes de un robot
	 */
	public ArrayList<String> genRobot() {
		Random r = new Random();
		ArrayList<String> conjunto = new ArrayList<>();
		
		System.out.print("Ingrese un nombre para el personaje: ");
		String n = sc.next();
		conjunto.add(n);
		for (int i = 0; i < 3; i++) {
			int number = r.nextInt((3-1)+1)+1;
			if(number == 1) {
				conjunto.add("Terminator");
			}else if(number == 2) {
				conjunto.add("C3PO");
			}else {
				conjunto.add("Robocop");
			}
			int acc = r.nextInt((2-1)+1)+1;
			if(acc == 1) {
				int numAcc = r.nextInt((5-1)+1)+1;
				conjunto.add(genAcc(numAcc, i));
			}else {
				conjunto.add("Null");
			}
		}
		return conjunto;
	}
	/**
	 * Metodo random de eleccion de partes de un superheroe
	 */
	public ArrayList<String> genSuperheroe() {
		Random r = new Random();
		ArrayList<String> conjunto = new ArrayList<>();
		
		System.out.print("Ingrese un nombre para el personaje: ");
		String n = sc.next();
		conjunto.add(n);
		for (int i = 0; i < 3; i++) {
			int number = r.nextInt((3-1)+1)+1;
			if(number == 1) {
				conjunto.add("Batman");
			}else if(number == 2) {
				conjunto.add("Deadpool");
			}else {
				conjunto.add("Iron_Man");
			}
			int acc = r.nextInt((2-1)+1)+1;
			if(acc == 1) {
				int numAcc = r.nextInt((5-1)+1)+1;
				conjunto.add(genAcc(numAcc, i));
			}else {
				conjunto.add("Null");
			}
		}
		return conjunto;
	}
	/**
	 * Metodo random de eleccion de partes de un futbolista
	 */
	public ArrayList<String> genFutbolista() {
		Random r = new Random();
		ArrayList<String> conjunto = new ArrayList<>();
		
		System.out.print("Ingrese un nombre para el personaje: ");
		String n = sc.next();
		conjunto.add(n);
		for (int i = 0; i < 3; i++) {
			int number = r.nextInt((3-1)+1)+1;
			if(number == 1) {
				conjunto.add("CR7");
			}else if(number == 2) {
				conjunto.add("Messi");
			}else {
				conjunto.add("Pibe");
			}
			int acc = r.nextInt((2-1)+1)+1;
			if(acc == 1) {
				int numAcc = r.nextInt((5-1)+1)+1;
				conjunto.add(genAcc(numAcc, i));
			}else {
				conjunto.add("Null");
			}
		}
		return conjunto;
	}
	/**
	 * Metodo random de eleccion de partes de un profesional
	 */
	public ArrayList<String> genProfesional() {
		Random r = new Random();
		ArrayList<String> conjunto = new ArrayList<>();
		
		System.out.print("Ingrese un nombre para el personaje: ");
		String n = sc.next();
		conjunto.add(n);
		for (int i = 0; i < 3; i++) {
			int number = r.nextInt((3-1)+1)+1;
			if(number == 1) {
				conjunto.add("Bombero");
			}else if(number == 2) {
				conjunto.add("Doctor");
			}else {
				conjunto.add("Policia");
			}
			int acc = r.nextInt((2-1)+1)+1;
			if(acc == 1) {
				int numAcc = r.nextInt((5-1)+1)+1;
				conjunto.add(genAcc(numAcc, i));
			}else {
				conjunto.add("Null");
			}
		}
		return conjunto;
	}
	/**
	 * Metodo random de eleccion de partes de una caricatura
	 */
	public ArrayList<String> genCaricatura() {
		Random r = new Random();
		ArrayList<String> conjunto = new ArrayList<>();
		
		System.out.print("Ingrese un nombre para el personaje: ");
		String n = sc.next();
		conjunto.add(n);
		for (int i = 0; i < 3; i++) {
			int number = r.nextInt((3-1)+1)+1;
			if(number == 1) {
				conjunto.add("Bugs_Bunny");
			}else if(number == 2) {
				conjunto.add("Homero_Simpson");
			}else {
				conjunto.add("Mario_Bros");
			}
			int acc = r.nextInt((2-1)+1)+1;
			if(acc == 1) {
				int numAcc = r.nextInt((5-1)+1)+1;
				conjunto.add(genAcc(numAcc, i));
			}else {
				conjunto.add("Null");
			}
		}
		return conjunto;
	}
	
	public String genAcc(int numAcc, int i) {
		String accesorio = "";
		if(i == 0) {
			if(numAcc == 1) {
				accesorio = "Sombrero_Vueltiao";
			}else if(numAcc == 2) {
				accesorio = "Peluca_Payaso";
			}else if(numAcc == 3) {
				accesorio = "Mascara_La_Purga";
			}else if(numAcc == 4) {
				accesorio = "Mascara_Anonymous";
			}else {
				accesorio = "Mascara_Samurai";
			}
		}else if(i == 1) {
			if(numAcc == 1) {
				accesorio = "Escudo_Cap_America";
			}else if(numAcc == 2) {
				accesorio = "Lightsaber";
			}else if(numAcc == 3) {
				accesorio = "Maletin";
			}else if(numAcc == 4) {
				accesorio = "Martillo_Thor";
			}else {
				accesorio = "Pistola";
			}
		}else if(i == 2) {
			if(numAcc == 1) {
				accesorio = "Balon_Futbol";
			}else if(numAcc == 2) {
				accesorio = "Botas_Rockeras";
			}else if(numAcc == 3) {
				accesorio = "Pantuflas_Sullivan";
			}else if(numAcc == 4) {
				accesorio = "Pantuflas_Unicornio";
			}else {
				accesorio = "Zapatos_Payaso";
			}
		}
		return accesorio;
	}
	
	/**
	 * Metodo para eleccion manual de un robot
	 */
	/*public void opcRobot() {
		System.out.println("Opciones:");
		System.out.println("* Terminator(1)\n* C3PO(2)\n* Robocop(3)");
		System.out.print("Cabeza: ");
		int cabeza = sc.nextInt();
		System.out.print("\nDorso: ");
		int dorso = sc.nextInt();
		System.out.print("\nPiernas: ");
		int piernas = sc.nextInt();
	}*/

}
