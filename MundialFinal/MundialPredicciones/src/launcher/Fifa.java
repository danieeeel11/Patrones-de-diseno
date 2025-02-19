package launcher;

import vista.Impresion;

public class Fifa {
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		Impresion.imprCSL("---- SIMULADOR DEL MUNDIAL QATAR 2022 ----");
		Menu m = new Menu(); 
		m.menu();
	}
}