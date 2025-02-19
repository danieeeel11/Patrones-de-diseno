package Cocina;

import java.util.Scanner;

import Productos.Component;

public abstract class Componente {
	Scanner sc = new Scanner(System.in);
	public abstract void getPrecio();
	abstract public void precioPlato(Component c); 
	abstract public void menuDesayuno1();
	abstract public void menuDesayuno2();
	abstract public void menuDesayuno3();
	abstract public void menuAlmuerzo1();
	abstract public void menuAlmuerzo2();
	abstract public void menuAlmuerzo3();
	public String bebidasCalientes() {
		String bebida = "";
		System.out.println("  ¿Que bebida desea?");
		System.out.println("    - cafe(1)\n    - chocolate(2)\n    - aromatica(3)");
		int opcion =sc.nextInt();
		boolean valido = false;
		while(valido != true) {
			if(opcion == 1) {
				bebida = "cafe";
				valido = true;
			}else if(opcion == 2) {
				bebida = "chocolate";
				valido = true;
			}else if(opcion == 3){
				bebida = "aromatica";
				valido = true;
			}else {
				System.out.println("Ingrese una opcion valida");
			}
		}
		return bebida;
	}
	public String bebidas() {
		String bebida = "";
		System.out.println("  ¿Que bebida desea?");
		System.out.println("    - jugo(1)\n    - sprite(2)\n    - limonada(3)");
		int opcion = sc.nextInt();
		boolean valido = false;
		while(valido != true) {
			if(opcion == 1) {
				bebida = "jugo";
				valido = true;
			}else if(opcion == 2) {
				bebida = "sprite";
				valido = true;
			}else if(opcion == 3){
				bebida = "limonada";
				valido = true;
			}else {
				System.out.println("Ingrese una opcion valida");
			}
		}
		return bebida;
	}
	public String frutas() {
		String fruta = "";
		System.out.println("  ¿Que fruta desea?");
		System.out.println("    - manzana(1)\n    - pera(2)\n    - mango(3)\n    - banano(4)\n    - fresa(5)");
		int opcion = sc.nextInt();
		boolean valido = false;
		while(valido != true) {
			if(opcion == 1) {
				fruta = "manzana";
				valido = true;
			}else if(opcion == 2) {
				fruta = "pera";
				valido = true;
			}else if(opcion == 3){
				fruta = "mango";
				valido = true;
			}else if(opcion == 4){
				fruta = "banano";
				valido = true;
			}else if(opcion == 5){
				fruta = "fresa";
				valido = true;
			}else {
				System.out.println("Ingrese una opcion valida");
			}
		}
		return fruta;
	}
}
