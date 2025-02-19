package Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	
	public ArrayList<String> menu(Scanner sc) {
        System.out.println("\n  MENU");
        System.out.println("    - Desayuno(1)\n    - Almuerzo(2)\n    - Cancelar(3)");
        System.out.print("  ¿Que servicio desea? ");
        int opc = sc.nextInt();
        
        switch(opc) {
        	case 1:
        		return menuDesayuno(sc, "Desayuno");
        	case 2:
        		return menuAlmuerzo(sc, "Almuerzo");
        	case 3:
        		System.out.println("-> SERVICIO DE RESTURANTE CANCELADO");
        }
        return null;
	}
	
	public ArrayList<String> menuDesayuno(Scanner sc, String tipo) {
		ArrayList<String> opciones = new ArrayList<>();
        System.out.println("	DESAYUNO");
        System.out.println("	  - Huevos revueltos(1)\n	  - Caldo(2)\n	  - Cereal(3)\n	  - Cancelar(4)");
        System.out.print("	¿Que plato desea? ");
        int opc = sc.nextInt();
        
        switch(opc){
            case 1,2,3:
            	opciones.add(tipo);
            	opciones.add(""+opc);
            	opciones.add(opcional(sc,"bebida","desayuno"));
            	opciones.add(opcional(sc,"fruta","desayuno"));
            	return opciones;
            case 4:
                System.out.println("-> SERVICIO CANCELADO");
        }
        return null;
	}
	
	public ArrayList<String> menuAlmuerzo(Scanner sc, String tipo) {
    	ArrayList<String> opciones = new ArrayList<>();
        System.out.println("	ALMUERZO");
        System.out.println("	  - Arroz con pollo(1)\n	  - Pescado frito(2)\n	  - Cerdo con garbanzo(3)\n	  - Cancelar(4)");
        System.out.print("	¿Que plato desea? ");
        int opc = sc.nextInt();
       
        switch(opc){
            case 1,2,3:
            	opciones.add(tipo);
            	opciones.add(""+opc);
            	opciones.add(opcional(sc,"bebida","almuerzo"));
            	opciones.add(opcional(sc,"fruta","almuerzo"));
            	return opciones;
            case 4:
                System.out.println("-> SERVICIO CANCELADO");
        }
        return null;
    }
	
	public String opcional(Scanner sc, String op, String tipo) {
		System.out.print("	¿Desea alguna " + op + "? Si(Y) No(N): ");
		String opcion = sc.next();
		boolean valido = false;
		while(valido != true) {
			if(opcion.equals("Y") || opcion.equals("y")) {
				if(op.equals("bebida") && tipo.equals("desayuno")){
					opcion = bebidasCalientes(sc);
				}else if(op.equals("bebida")) {
					opcion = bebidas(sc);
				}else if(op.equals("fruta")) {
					opcion = frutas(sc);
				}
				//opcion = "Y";
				valido = true;
			}else if(opcion.equals("N") || opcion.equals("n")){
				opcion = "N";
				valido = true;
			}else {
				System.out.print("	Ingrese una opcion valida: ");
				opcion = sc.next();
			}
		}
		return opcion;
	}
	
	public String bebidasCalientes(Scanner sc) {
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
	public String bebidas(Scanner sc) {
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
	public String frutas(Scanner sc) {
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
