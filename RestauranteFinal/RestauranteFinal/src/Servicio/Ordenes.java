package Servicio;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import Menu.Menu;

public class Ordenes {
	public static Map<Integer, Mesa> mesas = new HashMap<>();
	public static Map<Integer, Domicilio> domicilios = new HashMap<>();
	static Scanner sc = new Scanner(System.in);
	
	public static void ordenes() {
		Random random = new Random();
		boolean disponibilidad = false;
		
		if(mesas.size()==10) {
			System.out.println("No hay mesas disponibles, se deben cocinar los pedidos");
		}else {
			int numMesa = random.nextInt(10-1+1) + 1;
			
			while(!disponibilidad){
				disponibilidad = comprobarDisponibilidad(numMesa);
				if(!disponibilidad) {
					numMesa = random.nextInt(10-1+1) + 1;
				}
			}
			int idMesero = random.nextInt(4-1+1) + 1;
			
			if(!mesas.containsKey(numMesa)) {
				Mesero mesero = new Mesero(""+idMesero);
				System.out.println("\n* Mesa: " + numMesa);
				System.out.println("* Mesero: " + mesero.getNombre());
				Menu menu = new Menu();
				Mesa mesa = new Mesa(numMesa, mesero, menu.menu(sc));
				mesas.put(numMesa, mesa);
			}else {
				System.out.println("Mesa no disponible");
			}
		}
	}
	public static void domicilios() {
		Random random = new Random();
		boolean disponibilidad = false;

		if(domicilios.size()==10) {
			System.out.println("No hay domiciliarios disponibles, se deben entregar los pedidos");
		}else {
			int numDomicilio = random.nextInt(10-1+1) + 1;
			
			while(!disponibilidad){
				disponibilidad = comprobarDomicilios(numDomicilio);
				if(!disponibilidad) {
					numDomicilio = random.nextInt(10-1+1) + 1;
				}
			}
			int idDomiciliario = random.nextInt(4-1+1) + 1;
			
			if(!mesas.containsKey(numDomicilio)) {
				Domiciliario domiciliario = new Domiciliario(""+idDomiciliario);
				System.out.println("\n* Orden: " + numDomicilio);
				System.out.println("* Domiciliario: " + domiciliario.getNombre());
				Menu menu = new Menu();
				System.out.println("Porfavor ingrese su dirección");
				String direccion = sc.next();
				Domicilio domicilio = new Domicilio(numDomicilio, domiciliario, menu.menu(sc),direccion);
				domicilios.put(numDomicilio, domicilio);
			}else {
				System.out.println("Domiciliario no disponible");
			}
		}
	}
	
	public static boolean comprobarDisponibilidad(int numMesa) {
		if(mesas.containsKey(numMesa)) {
			return false;
		}
		return true;
	}
	public static boolean comprobarDomicilios(int numDomicilio) {
		if(domicilios.containsKey(numDomicilio)) {
			return false;
		}
		return true;
	}
	
	public static void OrdenesPendientes() {
		if(mesas.isEmpty()) {
			System.out.println("\n  No hay ordenes pendientes");
		}else {
			System.out.println("\n  Ordenes pendientes:");
			for (Map.Entry<Integer,Mesa> entry : mesas.entrySet()) {
				System.out.println("  Mesa: " + entry.getValue().getNumero() + ", Mesero: " + entry.getValue().getMesero().getNombre());
			}
		}
	}
	public static void DomiciliosPendientes() {
		if(domicilios.isEmpty()) {
			System.out.println("\n  No hay domicilios pendientes");
		}else {
			System.out.println("\n  Domicilios pendientes:");
			for (Map.Entry<Integer,Domicilio> entry : domicilios.entrySet()) {
				System.out.println("  Domicilio: " + entry.getValue().getNumero() + ", Domiciliario: " + entry.getValue().getDomiliciario().getNombre());
			}
		}
	}
}
