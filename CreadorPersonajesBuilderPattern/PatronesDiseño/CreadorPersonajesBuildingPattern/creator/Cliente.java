package creator;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Cliente {
	Scanner sc = new Scanner(System.in);
	Random r = new Random();

	public static void main(String[] args) {
		Cliente c = new Cliente();
		System.out.print("---- CREADOR DE PERSONAJES 2----");
		c.menu();
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
		    
			Director director = null;
			IBuilderPersonaje builderPersonaje = null;
			ArrayList<String> conjunto = null;
			switch(opc){
		       	case 1:
		       		director = new Director();
		       		builderPersonaje = new BuilderRobot();
		       		director.setBuilderPersonaje(builderPersonaje);
		       		conjunto = genRobot();
		       		break;
		       	case 2:
		       		director = new Director();
		       		builderPersonaje = new BuilderSuperheroe();
		       		director.setBuilderPersonaje(builderPersonaje);
		       		conjunto = genSuperheroe();
		       		break;
		       	case 3:
		       		director = new Director();
		       		builderPersonaje = new BuilderFutbolista();
		       		director.setBuilderPersonaje(builderPersonaje);
		       		conjunto = genFutbolista();
		       		break;
		       	case 4:
		       		director = new Director();
		       		builderPersonaje = new BuilderProfesional();
		       		director.setBuilderPersonaje(builderPersonaje);
		       		conjunto = genProfesional();
		       		break;
		       	case 5:
		       		director = new Director();
		       		builderPersonaje = new BuilderCaricatura();
		       		director.setBuilderPersonaje(builderPersonaje);
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
				director.builderPersonaje(conjunto.get(0), conjunto.get(1), conjunto.get(2), conjunto.get(3), conjunto.get(4), conjunto.get(5), conjunto.get(6), conjunto.get(7));
				Personaje personaje = director.getPersonaje();
				
				System.out.println(personaje.getNombre());
				System.out.println(personaje.getTipo());
				System.out.println(personaje.getCabeza());
				if(!personaje.accCabeza.equals("Null")) {
					System.out.println(personaje.getAccCabeza());
				}
				System.out.println(personaje.getDorso());
				if(!personaje.accDorso.equals("Null")) {
					System.out.println(personaje.getAccDorso());
				}
				System.out.println(personaje.getPiernas());
				if(!personaje.accPiernas.equals("Null")) {
					System.out.println(personaje.getAccPiernas());
				}
				
				System.out.println("\n-------------------------------");
			}
			
	   	}
	}
	
	/**
	 * Metodo random de eleccion de partes de un robot
	 */
	public ArrayList<String> genRobot() {
		ArrayList<String> conjunto = new ArrayList<>();
		
		System.out.print("Ingrese un nombre para el personaje: ");
		String n = sc.next();
		conjunto.add(n);
		conjunto.add("Robot");
		for (int i = 0; i < 3; i++) {
			int number = r.nextInt((3-1)+1)+1;
			if(number == 1) {
				conjunto.add("Terminator");
			}else if(number == 2) {
				conjunto.add("C3PO");
			}else {
				conjunto.add("Robocop");
			}
			generatorAcc(number, i, conjunto);
		}
		return conjunto;
	}
	/**
	 * Metodo random de eleccion de partes de un superheroe
	 */
	public ArrayList<String> genSuperheroe() {
		//Random r = new Random();
		ArrayList<String> conjunto = new ArrayList<>();
		
		System.out.print("Ingrese un nombre para el personaje: ");
		String n = sc.next();
		conjunto.add(n);
		conjunto.add("Superheroe");
		for (int i = 0; i < 3; i++) {
			int number = r.nextInt((3-1)+1)+1;
			if(number == 1) {
				conjunto.add("Batman");
			}else if(number == 2) {
				conjunto.add("Deadpool");
			}else {
				conjunto.add("Iron_Man");
			}
			generatorAcc(number, i, conjunto);
		}
		return conjunto;
	}
	/**
	 * Metodo random de eleccion de partes de un futbolista
	 */
	public ArrayList<String> genFutbolista() {
		//Random r = new Random();
		ArrayList<String> conjunto = new ArrayList<>();
		
		System.out.print("Ingrese un nombre para el personaje: ");
		String n = sc.next();
		conjunto.add(n);
		conjunto.add("Futbolista");
		for (int i = 0; i < 3; i++) {
			int number = r.nextInt((3-1)+1)+1;
			if(number == 1) {
				conjunto.add("CR7");
			}else if(number == 2) {
				conjunto.add("Messi");
			}else {
				conjunto.add("Pibe");
			}
			generatorAcc(number, i, conjunto);
		}
		return conjunto;
	}
	/**
	 * Metodo random de eleccion de partes de un profesional
	 */
	public ArrayList<String> genProfesional() {
		//Random r = new Random();
		ArrayList<String> conjunto = new ArrayList<>();
		
		System.out.print("Ingrese un nombre para el personaje: ");
		String n = sc.next();
		conjunto.add(n);
		conjunto.add("Profesional");
		for (int i = 0; i < 3; i++) {
			int number = r.nextInt((3-1)+1)+1;
			if(number == 1) {
				conjunto.add("Bombero");
			}else if(number == 2) {
				conjunto.add("Doctor");
			}else {
				conjunto.add("Policia");
			}
			generatorAcc(number, i, conjunto);
		}
		return conjunto;
	}
	/**
	 * Metodo random de eleccion de partes de una caricatura
	 */
	public ArrayList<String> genCaricatura() {
		//Random r = new Random();
		ArrayList<String> conjunto = new ArrayList<>();
		
		System.out.print("Ingrese un nombre para el personaje: ");
		String n = sc.next();
		conjunto.add(n);
		conjunto.add("Caricatura");
		for (int i = 0; i < 3; i++) {
			int number = r.nextInt((3-1)+1)+1;
			if(number == 1) {
				conjunto.add("Bugs_Bunny");
			}else if(number == 2) {
				conjunto.add("Homero_Simpson");
			}else {
				conjunto.add("Mario_Bros");
			}
			generatorAcc(number, i, conjunto);
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
	
	public void generatorAcc(int number, int i, ArrayList<String> conjunto) {
		if(number%2!=0) {
			//Mas de un accesorio
			int cantidadAcc = r.nextInt(6-2)+2;
			ArrayList<Integer> numeros = new ArrayList<>();
			numeros.add(1);
			numeros.add(2);
			numeros.add(3);
			numeros.add(4);
			numeros.add(5);
			String accesorios = "";
			for (int j = 0; j < cantidadAcc; j++) {
				//System.out.println("cantidad:" + cantidadAcc + ", " + numeros.size());
				int indexRandom = r.nextInt((numeros.size()-1)+1)+1;
				if(j == (cantidadAcc-1)) {
					accesorios += genAcc(numeros.get(indexRandom-1), i);
				}else {
					accesorios += genAcc(numeros.get(indexRandom-1), i) + ",";
				}
				numeros.remove(indexRandom-1);
			}
			conjunto.add(accesorios);
		}else {
			int acc = r.nextInt((2-1)+1)+1;
			if(acc == 1) {
				int numAcc = r.nextInt((5-1)+1)+1;
				conjunto.add(genAcc(numAcc, i));
			}else {
				conjunto.add("Null");
			}
		}
	}

}
